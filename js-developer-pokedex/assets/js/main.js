const pokemonList = document.getElementById('pokemonList')
const loadMoreButton = document.getElementById('loadMoreButton')
const previousButton = document.getElementById('previousButton')
const nextButton = document.getElementById('nextButton')

const maxRecords = 151
const limit = 5
let offset = 0;

function convertPokemonToLi(pokemon) {//retorna uma string com o html de li
    return `
        <a href="details.html">
            <li class="pokemon ${pokemon.type}">
                <span class="number">#${pokemon.number}</span>
                <span class="name">${pokemon.name}</span>

                <div class="detail">
                    <ol class="types">
                        ${pokemon.types.map((type) => `<li class="type ${type}">${type}</li>`).join('')}
                    </ol>

                    <img src="${pokemon.photo}"
                        alt="${pokemon.name}">
                </div>
            </li>
        </a>
    `
}


function loadPokemonItens(offset, limit) {
    pokeApi.getPokemons(offset, limit).then((pokemons = []) => {
        const newHtml = pokemons.map(convertPokemonToLi).join('')// para cada item da lista chama a função que retorna uma string de li concatenando join(" ") com separador
        pokemonList.innerHTML = newHtml //renderizando o html
    })
}

loadPokemonItens(offset, limit)

loadMoreButton.addEventListener('click', () => {
    offset += limit
    const qtdRecordsWithNexPage = offset + limit

    if (qtdRecordsWithNexPage >= maxRecords) {
        const newLimit = maxRecords - offset
        loadPokemonItens(offset, newLimit)

        loadMoreButton.parentElement.removeChild(loadMoreButton)
    } else {
        loadPokemonItens(offset, limit)
    }
})

previousButton.addEventListener('click', () => {
    if (offset >= limit) {
        offset -= limit
    }
    const qtdRecordsWithPreviousPage = offset - limit

    if (qtdRecordsWithPreviousPage >= maxRecords) {
        const newLimit = maxRecords - offset
        loadPokemonItens(offset, newLimit)

        previousButton.parentElement.removeChild(previousButton)
    } else {
        loadPokemonItens(offset, limit)
    }
})


