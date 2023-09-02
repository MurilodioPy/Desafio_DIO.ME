class CardNews extends HTMLElement{//component com shadow DOM
    constructor(){
        super();
        const shadow = this.attachShadow({mode: "open"}) //open - mundo exterior pode manipular os elementos
        shadow.innerHTML = "<h1>Hello World</h1>"
        shadow.appendChild(this.build());
        shadow.appendChild(this.style());
    }
    // construindo o componente com pais e filhos
    build(){
        const componentRoot = document.createElement("div");
        componentRoot.setAttribute("class", "card");
        
        const cardleft = document.createElement("div");
        cardleft.setAttribute("class", "card-left");

        const autor = document.createElement("span");
        autor.textContent = "By" + (this.getAttribute("autor") || "Anonymous");

        const linkTitle = document.createElement("a");
        linkTitle.textContent = this.getAttribute("title")
        const newsContent = document.createElement("p");
        newsContent.textContent = this.getAttribute("content")
        
        cardleft.appendChild(autor);
        cardleft.appendChild(linkTitle);
        cardleft.appendChild(newsContent);
        
        const cardright = document.createElement("div");
        cardright.setAttribute("class", "card-right");
        
        const newsImage = document.createElement("p");
        cardright.appendChild(newsImage)
        
        componentRoot.appendChild(cardleft);
        componentRoot.appendChild(cardright);

        return componentRoot;
    }

    style(){

    }

}

customElements.define('card-news', CardNews) // definindo o nome do elemento