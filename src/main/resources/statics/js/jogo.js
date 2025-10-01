document.addEventListener('DOMContentLoaded', () => {
 const glitchText = document.querySelector('.glitch-text');
    if (glitchText) {
        glitchText.addEventListener('mouseover', () => {
            glitchText.style.animation = 'glitch-effect 1s steps(2, end) infinite';
        });
        glitchText.addEventListener('mouseout', () => {
            glitchText.style.animation = 'none';
        });
    }

    const downloadCards = document.querySelectorAll('.download-card');
    downloadCards.forEach(card => {
        card.addEventListener('mouseover', () => {
            card.style.transform = 'scale(1.05)';
            card.style.transition = 'transform 0.3s ease';
        });
        card.addEventListener('mouseout', () => {
            card.style.transform = 'scale(1)';
        });
    });

    const downloadBtns = document.querySelectorAll('.download-btn');
    downloadBtns.forEach(btn => {
        btn.addEventListener('click', (e) => {
            e.preventDefault();
            const parentCard = btn.closest('.download-card');
            const platform = parentCard.dataset.platform;

            btn.textContent = 'Baixando...';
            btn.classList.add('downloading');
            btn.disabled = true;

            setTimeout(() => {
                btn.textContent = 'Instalado!';
                btn.classList.remove('downloading');
                btn.classList.add('download-complete');
                btn.disabled = false;

            }, 3000);
        });
    });
});