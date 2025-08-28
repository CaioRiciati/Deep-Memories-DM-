  const openModal = document.querySelector(".perfil a");
  const modal = document.querySelector(".container2");

  openModal.addEventListener("click", (e) => {
    e.preventDefault();
    modal.style.display = "flex";
  });

  // fechar clicando fora do content2
  modal.addEventListener("click", (e) => {
    if (e.target === modal) {
      modal.style.display = "none";
    }
  });

