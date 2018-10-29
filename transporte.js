function cambiartransporte(objeto)
{
  if(objeto == 'metro_')
  {
    document.getElementById("metro").style.display = "block";
    document.getElementById("autobus").style.display = "none";
    document.getElementById("taxi").style.display = "none";
  }
  if(objeto == 'autobus_')
  {
    document.getElementById("metro").style.display = "none";
    document.getElementById("taxi").style.display = "none";
    document.getElementById("autobus").style.display = "block";
  }
  if(objeto == 'taxi_')
  {
    document.getElementById("metro").style.display = "none";
    document.getElementById("taxi").style.display = "block";
    document.getElementById("autobus").style.display = "none";
  }
}