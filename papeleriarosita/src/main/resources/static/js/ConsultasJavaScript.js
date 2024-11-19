var x = document.getElementById("Clientes");
var y = document.getElementById("Proveedores");
var z = document.getElementById("Productos");
var a = document.getElementById("Pedidos");
var f = document.getElementById("Inventario")
var s = document.getElementById("Ventas")
var b = document.getElementById("elegir");

function changeActive(id){
clearActiveClass();
document.getElementById(id).classList.add("active");
switch(id) {
case "btnCliente":
    x.style.left = "335px";
    y.style.left = "2000px";
    z.style.left = "2000px";
    a.style.left = "2000px";
    f.style.left = "2000px";
    s.style.left = "2000px";
    b.style.left = "0px";
    break;
case "btnProveedores":
    x.style.left = "-2000px";
    y.style.left = "335px";
    z.style.left = "2000px";
    a.style.left = "2000px";
    f.style.left = "2000px";
    s.style.left = "2000px";
    b.style.left = "97px";
    break;
case "btnProductos":
    x.style.left = "-2000px";
    y.style.left = "-2000px";
    z.style.left = "335px";
    a.style.left = "2000px";
    f.style.left = "2000px";
    s.style.left = "2000px";
    b.style.left = "205px";
    break;
case "btnPedidos":
    x.style.left = "-2000px";
    y.style.left = "-2000px";
    z.style.left = "-2000px";
    a.style.left = "335px";
    f.style.left = "2000px";
    s.style.left = "2000px";
    b.style.left = "300px";
    break;
case "btnInventario":
    x.style.left = "-2000px";
    y.style.left = "-2000px";
    z.style.left = "-2000px";
    a.style.left = "-2000px";
    f.style.left = "335px";
    s.style.left = "2000px";
    b.style.left = "395px";
    break;
case "btnVentas":
        x.style.left = "-2000px";
        y.style.left = "-2000px";
        z.style.left = "-2000px";
        a.style.left = "-2000px";
        f.style.left = "-2000px";
        s.style.left = "335px";
        b.style.left = "485px";
        break;
}
}

function clearActiveClass() {
var buttons = document.getElementsByClassName("toggle-btn");
for (var i = 0; i < buttons.length; i++) {
buttons[i].classList.remove("active");
}
}
