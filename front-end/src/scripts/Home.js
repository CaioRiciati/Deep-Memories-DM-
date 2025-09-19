    const btn = document.getElementById('btn-menu');
    const menu = document.querySelector('.menu');


    btn.addEventListener('click', () => {
        btn.classList.toggle('active');
        menu.classList.toggle('show');
});

window.addEventListener('scroll', function() {
    const header = document.querySelector('header');

    if (window.scrollY > 100) {
        header.classList.add('scrolled');
    } else {
        header.classList.remove('scrolled');
    }
});