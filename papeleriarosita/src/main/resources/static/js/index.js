let menuToggle = document.querySelector('.menuToggle');
        let sidebar = document.querySelector('.sidebar');
        menuToggle.onclick = function(){
            menuToggle.classList.toggle('active');
            sidebar.classList.toggle('active');
        }

        let Menulist = document.querySelectorAll('.Menulist li');
        function activeLink(){
            Menulist.forEach((item) =>
            item.classList.remove('active'));
            this.classList.add('active')
        }
        Menulist.forEach((item)=>
        item.addEventListener('click', activeLink));

     function loadPage(url) {
            var iframe = document.getElementById('content-frame');
            iframe.src = url;
            iframe.style.backgroundImage = 'none';
            iframe.style.backgroundColor = 'white';
        }
