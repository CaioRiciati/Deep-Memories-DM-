    const btn = document.getElementById('btn-menu');
    const menu = document.querySelector('.menu');


    btn.addEventListener('click', () => {
        btn.classList.toggle('active');
        menu.classList.toggle('show');
});