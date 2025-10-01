const API_BASE_URL = "http://localhost:8082";

const login = async (email, senha) => {
  const response = await fetch(`${API_BASE_URL}/login`, {
    method: "POST",
    headers: { "Content-Type": "application/json" },
    body: JSON.stringify({ email, senha })
  });

  if (!response.ok) throw new Error("Erro no login");

  const data = await response.json();
  localStorage.setItem("token", data.token);
  return data;
};

const apiGet = async (endpoint) => {
  const token = localStorage.getItem("token");

  const response = await fetch(`${API_BASE_URL}${endpoint}`, {
    method: "GET",
    headers: {
      "Content-Type": "application/json",
      "Authorization": `Bearer ${token}`
    }
  });

  if (!response.ok) throw new Error("Erro no GET");

  return response.json();
};

const apiPost = async (endpoint, body) => {
  const token = localStorage.getItem("token");

  const response = await fetch(`${API_BASE_URL}${endpoint}`, {
    method: "POST",
    headers: {
      "Content-Type": "application/json",
      "Authorization": `Bearer ${token}`
    },
    body: JSON.stringify(body)
  });

  if (!response.ok) throw new Error("Erro no POST");

  return response.json();
};
