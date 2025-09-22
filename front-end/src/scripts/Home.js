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

document.addEventListener('DOMContentLoaded', () => {
  const cards = document.querySelectorAll('.card');

  cards.forEach(card => {
    card.addEventListener('click', () => {
      cards.forEach(c => {
        c.classList.remove('expanded');
      });

      card.classList.add('expanded');
    });
  });
});