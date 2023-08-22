// Call the dataTables jQuery plugin
$(document).ready(function () {
  load();
  $("#table").DataTable();
});

async function load() {
  const request = await fetch("api/pets", {
    method: "GET",
    headers: {
      Accept: "application/json",
      "Content-Type": "application/json",
    },
  });

  const pets = await request.json();

  let html = "";
  for (let pet of pets) {
    let getButton =
      '<a href="#" onclick="getRecord(' +
      pet.id +
      ')" class="btn btn-primary btn-circle btn-sm"><i class="fas fa-eye"></i></a>';

    let updateButton =
      '<a href="#" onclick="updateRecord(' +
      pet.id +
      ')" class="btn btn-warning btn-circle btn-sm"><i class="fas fa-pencil"></i></a>';

    let deleteButton =
      '<a href="#" onclick="deleteRecord(' +
      pet.id +
      ')" class="btn btn-danger btn-circle btn-sm"><i class="fas fa-trash"></i></a>';

    let rowHtml =
      "<tr><td>" +
      pet.id +
      "</td><td>" +
      pet.name +
      "</td><td>" +
      pet.petType.name +
      "</td><td>" +
      pet.breed +
      "</td><td>" +
      (pet.gender == "male"
        ? '<i class="fas fa-venus color-primary"></i>'
        : '<i class="fas fa-mars color-primary"></i>') +
      "</td><td>" +
      pet.age +
      "</td><td>" +
      getButton +
      updateButton +
      deleteButton +
      "</td></tr>";
    html += rowHtml;
  }

  document.querySelector("#table tbody").outerHTML = html;
}

async function deleteRecord(id) {
  if (!confirm(`¿Desea eliminar este registro`)) {
    return;
  }

  function getHeaders() {
    return {
      Accept: "application/json",
      "Content-Type": "application/json",
      Authorization: localStorage.token,
    };
  }

  const request = await fetch("api/pets/" + id, {
    method: "DELETE",
    headers: getHeaders(),
  });

  location.reload();
}
