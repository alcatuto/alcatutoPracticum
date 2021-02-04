
     
    
  //Funcion principal
    initMap = function () 
    {
        //usamos la API para geolocalizar el usuario
            navigator.geolocation.getCurrentPosition(
              function (position){
                coords =  {
                  lng: position.coords.longitude,
                  lat: position.coords.latitude
                };
                dibujarMapa(coords, locationsInfo);  //pasamos las coordenadas al metodo para crear el mapa
                
               
              },function(error){console.log(error);});
        
    }
    
  
    function dibujarMapa (coords, locationsInfo)
    {   
          //Se crea una nueva instancia del objeto mapa
          var map = new google.maps.Map(document.getElementById('map'),
          {
            zoom: 13,
            center:coords

          });

          //Creamos el marcador en el mapa con sus propiedades
          //para nuestro obetivo tenemos que poner el atributo draggable en true
          //position pondremos las mismas coordenas que obtuvimos en la geolocalización
          marker = new google.maps.Marker({
            map: map,
            position: coords,
            title: 'Tu ubicacion'
          });
          
          let markers = locationsInfo.map(place => {
              return new google.maps.Marker({
                  position: place.position,
                  map: map,
                  title: place.name
              })
          })
          
          //agregamos un evento al marcador junto con la funcion callback al igual que el evento dragend que indica 
          //cuando el usuario a soltado el marcador
          marker.addListener('click', toggleBounce);
          
          marker.addListener( 'dragend', function (event)
          {
            //escribimos las coordenadas de la posicion actual del marcador dentro del input #coords
            document.getElementById("coords").value = this.getPosition().lat()+","+ this.getPosition().lng();
          });
    }