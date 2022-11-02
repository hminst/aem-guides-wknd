let xhr = new XMLHttpRequest();
let pokemonObj = null;
xhr.onreadystatechange = function() {
    if (xhr.readyState === XMLHttpRequest.DONE) {
        pokemonObj = JSON.parse(xhr.responseText);
        document.getElementById('pokemon-image').src = pokemonObj.sprites.front_default;
    }
};
xhr.open('GET', 'https://pokeapi.co/api/v2/pokemon/413/', true);
xhr.send(null);

window.addEventListener('DOMContentLoaded', () => {
    console.log('DOM fully loaded and parsed');
    document.getElementById('cmp-ntcontact__button').addEventListener('click', () => {
        document.getElementsByClassName('cmp-ntcontact__firstName')[0].style.color = 'fuchsia';
        document.getElementsByClassName('cmp-ntcontact__lastName')[0].style.color = 'fuchsia';
    });
});
