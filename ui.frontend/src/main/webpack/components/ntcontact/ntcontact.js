function setInitialPokemonImage(pokemonId) {
    let xhr = new XMLHttpRequest();
    let pokemonObj = null;
    xhr.onreadystatechange = function() {
        if (xhr.readyState === XMLHttpRequest.DONE) {
            pokemonObj = JSON.parse(xhr.responseText);
            console.log('POOOO: ', pokemonObj);
            document.getElementById('pokemon-image').src = pokemonObj.sprites.front_default;
        }
    };
    xhr.open('GET', `https://pokeapi.co/api/v2/pokemon/${pokemonId}/`, true);
    xhr.send(null);
}

function setPokemonData() {
    let xhr = new XMLHttpRequest();
    let pokemonObj = null;
    xhr.onreadystatechange = function() {
        if (xhr.readyState === XMLHttpRequest.DONE) {
            pokemonObj = JSON.parse(xhr.responseText);
            document.getElementsByClassName('cmp-ntcontact__firstName-span')[0].textContent = pokemonObj.name;
            document.getElementsByClassName('cmp-ntcontact__lastName-span')[0].textContent = pokemonObj.name;
            document.getElementById('pokemon-image').src = pokemonObj.sprites.front_default;
        }
    };
    xhr.open('GET', `https://pokeapi.co/api/v2/pokemon/${getRandomInt(100).toString()}/`, true);
    xhr.send(null);
}

if (document.readyState !== "loading") {
    setInitialPokemonImage('413');
    document.getElementById('cmp-ntcontact__button').addEventListener('click', () => {
        document.getElementsByClassName('cmp-ntcontact__firstName')[0].style.color = 'fuchsia';
        document.getElementsByClassName('cmp-ntcontact__lastName')[0].style.color = 'fuchsia';
    });
    document.getElementById('cmp-ntcontact__magic-button').addEventListener('click', () => {
        setPokemonData();
    });
}

function getRandomInt(max) {
    return Math.floor(Math.random() * max);
}
