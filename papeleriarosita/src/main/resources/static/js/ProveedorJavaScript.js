var x = document.getElementById("Buscar");
var y = document.getElementById("Crear");
var z = document.getElementById("Actualizar");
var a = document.getElementById("Borrar");
var b = document.getElementById("elegir");
var c = document.getElementById("Buscar2");
var d = document.getElementById("Crear2");
var e = document.getElementById("Actualizar2");
var f = document.getElementById("Borrar2");
var g = document.getElementById("elegir2");

function changeActiveFamilia(id){
    clearActiveClassFamilia();
    document.getElementById(id).classList.add("active");
    switch(id) {
        case "btnBuscar":
            x.style.left = "118px";
            y.style.left = "2000px";
            z.style.left = "2000px";
            a.style.left = "2000px";
            b.style.left = "0px";
            break;
        case "btnCrear":
            x.style.left = "-2000px";
            y.style.left = "118px";
            z.style.left = "2000px";
            a.style.left = "2000px";
            b.style.left = "77px";
            break;
        case "btnActualizar":
            x.style.left = "-2000px";
            y.style.left = "-2000px";
            z.style.left = "118px";
            a.style.left = "2000px";
            b.style.left = "163px";
            break;
        case "btnBorrar":
            x.style.left = "-2000px";
            y.style.left = "-2000px";
            z.style.left = "-2000px";
            a.style.left = "118px";
            b.style.left = "257px";
            break;
    }
}

function changeActiveGenero(id){
    clearActiveClassGenero();
    document.getElementById(id).classList.add("active");
    switch(id) {
    case "btnBuscar2":
        c.style.left = "118px";
        d.style.left = "2000px";
        e.style.left = "2000px";
        f.style.left = "2000px";
        g.style.left = "0px";
        break;
    case "btnCrear2":
        c.style.left = "-2000px";
        d.style.left = "118px";
        e.style.left = "2000px";
        f.style.left = "2000px";
        g.style.left = "80px";
        break;
  
    }
}

function clearActiveClassFamilia() {
    var buttons = document.querySelectorAll(".container .toggle-btn");
    for (var i = 0; i < buttons.length; i++) {
        buttons[i].classList.remove("active");
    }
}

function clearActiveClassGenero() {
    var buttons = document.querySelectorAll(".container2 .toggle-btn");
    for (var i = 0; i < buttons.length; i++) {
        buttons[i].classList.remove("active");
    }
}