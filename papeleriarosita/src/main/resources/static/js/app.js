const inputs = document.querySelectorAll(".input-field");
const main = document.querySelector("main");
const bullets = document.querySelectorAll(".bullets span");
const images = document.querySelectorAll(".image");

inputs.forEach((inp) => {
  inp.addEventListener("focus", () => {
    inp.classList.add("active");
  });
  inp.addEventListener("blur", () => {
    if (inp.value != "") return;
    inp.classList.remove("active");
  });
});

function moveSlider() {
  let index = this.dataset.value;

  let currentImage = document.querySelector(`.img-${index}`);
  images.forEach((img) => img.classList.remove("show"));
  currentImage.classList.add("show");

  const textSlider = document.querySelector(".text-group");
  textSlider.style.transform = `translateY(${-(index - 1) * 2.2}rem)`;

  bullets.forEach((bull) => bull.classList.remove("active"));
  this.classList.add("active");
}

bullets.forEach((bullet) => {
  bullet.addEventListener("click", moveSlider);
});

// Función para cambiar automáticamente las imágenes cada 5 segundos
function autoChangeSlider() {
  setInterval(() => {
    let currentIndex = 1;
    const activeBullet = document.querySelector('.bullets span.active');
    if (activeBullet) {
      currentIndex = parseInt(activeBullet.dataset.value);
      // Incrementa el índice de la imagen actual
      currentIndex = currentIndex % 3 + 1; // 3 es el número total de imágenes
    }
    // Obtiene el siguiente bullet y lo activa
    const nextBullet = document.querySelector(`.bullets span[data-value="${currentIndex}"]`);
    if (nextBullet) {
      moveSlider.call(nextBullet);
    }
  }, 5000); // Cambia la imagen cada 5 segundos
}

// Llama a la función para cambiar automáticamente las imágenes
autoChangeSlider();

function loadPage(url) {
  window.location.href = url;
}