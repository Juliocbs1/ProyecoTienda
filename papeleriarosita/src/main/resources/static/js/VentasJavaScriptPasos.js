let currentPage = 1;
const totalPages = 4;

function nextPage() {
  const nextPageNumber = currentPage + 1;
  if (nextPageNumber <= totalPages) {
    redirectToStep(nextPageNumber);
  } else {
    alert('Venta finalizada');
  }
}

function redirectToStep(pageNumber) {
    window.location.href = `Paso${pageNumber}.html`;
}

document.getElementById('addFields').addEventListener('click', function() {
  document.getElementById('extraFields').classList.toggle('hidden');
});

document.getElementById("nuevaPestanaBtn").addEventListener("click", function() {
            window.open("/venta", "_blank");
        });