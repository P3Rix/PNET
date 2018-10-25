var imagenes=new Array(
        'Imagenes/hotel1.jpg',
        'Imagenes/hotel3.jpg',
        'Imagenes/hotel4.jpg'
    );

    /**
    * Funcion para cambiar la imagen
    */
    function rotarImagenes()
    {
        // obtenemos un numero aleatorio entre 0 y la cantidad de imagenes que hay
        var index=Math.floor((Math.random()*imagenes.length));

        // cambiamos la imagen
        document.getElementById("imagen").src=imagenes[index];
    }

    /**
    * Función que se ejecuta una vez cargada la página
    */
    onload=function()
    {
        // Cargamos una imagen aleatoria
        rotarImagenes();

        // Indicamos que cada 4 segundos cambie la imagen
        setInterval(rotarImagenes,4000);
    }
