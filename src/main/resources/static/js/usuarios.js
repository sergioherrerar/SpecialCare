// Call the dataTables jQuery plugin
$(document).ready(function() {
    cagarUsuarios();
  $('#usuarios').DataTable();
});

async function cagarUsuarios() {

  const request = await fetch('usuarios', {
    method: 'GET',
    headers: {
      'Accept': 'application/json',
      'Content-Type': 'application/json'
    }
  });

  const usuarios = await request.json();
  let listadoHtml = "";
  for (let usuario of usuarios){
    let usuarioHtml = '<tr><td>'+usuario.id+'</td><td>'+usuario.First_Name+' '+usuario.Second_Name+' '+usuario.Lastname+' '+usuario.Second_Lastname+'</td><td>'
            + usuario.email+'</td><td>'+usuario.password+'</td><td>'+usuario.Phone_Number
            + '</td><td><a href="#" class="btn btn-danger btn-circle btn-sm"><i class="fas fa-trash"></i></a><a href="#" class="btn btn-warning btn-circle btn-sm"><i class="fas fa-exclamation-triangle"></i></a><a href="#" class="btn btn-info btn-circle btn-sm"><i class="fas fa-info-circle"></i></a></td></tr>';

    listadoHtml += usuarioHtml;
  }
document.querySelector("#usuarios tbody").outerHTML="listadoHtml";

}