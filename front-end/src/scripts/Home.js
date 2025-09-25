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


  window.addEventListener('load', function () {
    const inicio = document.querySelector('.inicio');
    if (inicio) {
      setTimeout(() => {
        inicio.classList.add('animado');
      }, 100);
    }
    animarAoScroll();
  });

  window.addEventListener('scroll', animarAoScroll);

  function animarAoScroll() {
    const elementos = document.querySelectorAll('.scroll-animado');
    const alturaTela = window.innerHeight;

    elementos.forEach(el => {
      const posicao = el.getBoundingClientRect().top;
      if (posicao < alturaTela - 100) {
        el.classList.add('apareceu');
      }
    });
  }
