function cambiarhorarios(objeto)
{
  if(objeto == 'Friday')
  {
    document.getElementById("viernes").style.display = "block";
    document.getElementById("domingo").style.display = "none";
    document.getElementById("sabado").style.display = "none";
  }
  if(objeto == 'Saturday')
  {
    document.getElementById("viernes").style.display = "none";
    document.getElementById("domingo").style.display = "none";
    document.getElementById("sabado").style.display = "block";
  }
  if(objeto == 'Sunday')
  {
    document.getElementById("viernes").style.display = "none";
    document.getElementById("domingo").style.display = "block";
    document.getElementById("sabado").style.display = "none";
  }
}
