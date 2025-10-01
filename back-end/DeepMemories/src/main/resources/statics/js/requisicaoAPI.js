const URL = 'http://localhost:8080';

async function chamarAPI() {
    const resp = await fetch(URL);
    if (resp.status === 200) {
        const obj = await resp.json();
        console.log(obj)
        
    }
    
}

chamarAPI();