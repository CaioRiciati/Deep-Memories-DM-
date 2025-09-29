const modal = document.getElementById('modal');
const openBtn = document.getElementById('openModal');

openBtn.addEventListener('click', (e) => {
  e.preventDefault();
  modal.classList.add('is-open');
  modal.setAttribute('aria-hidden', 'false');
});

modal.addEventListener('click', (e) => {
  if (e.target === modal || e.target.closest('[data-close]')) {
    modal.classList.remove('is-open');
    modal.setAttribute('aria-hidden', 'true');
  }
});

document.addEventListener('keydown', (e) => {
  if (e.key === 'Escape' && modal.classList.contains('is-open')) {
    modal.classList.remove('is-open');
    modal.setAttribute('aria-hidden', 'true');
  }
});
