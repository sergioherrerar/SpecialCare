// Call the dataTables jQuery plugin
$(document).ready(function() {
    cagarpets();
  $('#pets').DataTable();
});

async function cagarpets() {

  const request = await fetch('pets', {
    method: 'GET',
    headers: {
      'Accept': 'application/json',
      'Content-Type': 'application/json'
    }
  });

  const pets = await request.json();

   let listadopetHtml = '';
    for (let pet of pets) {
      let botonEliminar = '<a href="#" onclick="eliminarPet(' + pet.id + ')" class="btn btn-danger btn-circle btn-sm"><i class="fas fa-trash"></i></a>';

      let petHtml = '<tr><td>'+pet.id+'</td><td>' + pet.name + ' ' + pet.pet_tipe+ '</td><td>'
                      + pet.birthday_date+'</td><td>'+pet.age +'<td>'+pet.gender
                      + '</td><td>' + botonEliminar + '</td></tr>';
      listadopetHtml += petHtml;
    }

document.querySelector("#pets tbody").outerHTML=listadopetHtml;