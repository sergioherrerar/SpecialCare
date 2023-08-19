// Call the dataTables jQuery plugin
$(document).ready(function() {
    cagarpets();
  $('#pets').DataTable();
});

async function cagarPets() {

  const request = await fetch('pets', {
    method: 'GET',
    headers: {
      'Accept': 'application/json',
      'Content-Type': 'application/json'
    }
  });

  const pets = await request.json();
  let listadoHtml = "";
  for (let pet of pets){
    let petHtml = '<tr><td>'+ pet.id +'</td><td>'+ pet.name +'</td><td>'+ pet.pet_Tipe +'</td><td>'+ pet.Birthday_date +'</td><td>'+ pet.age+'</td><td>'+ pet.danger
     +'</td><a href="#" class="btn btn-danger btn-circle btn-sm"><i class="fas fa-trash"></i></a><a href="#" class="btn btn-warning btn-circle btn-sm"><i class="fas fa-exclamation-triangle"></i></a><a href="#" class="btn btn-info btn-circle btn-sm"><i class="fas fa-info-circle"></i></a></td></tr>';

    listadoHtml += petHtml;
  }
document.querySelector("#pets tbody").outerHTML="listadoHtml";

}