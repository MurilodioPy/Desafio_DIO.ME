class CardNews extends HTMLElement{//component com shadow DOM
    constructor(){
        super();
        const shadow = this.attachShadow({mode: "open"}) //open - mundo exterior pode manipular os elementos
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
        autor.textContent = "By " + (this.getAttribute("autor") || "Anonymous");

        const linkTitle = document.createElement("a");
        linkTitle.textContent = this.getAttribute("title");
        linkTitle.href = this.getAttribute("link-url");
        const newsContent = document.createElement("p");
        newsContent.textContent = this.getAttribute("content");

        cardleft.appendChild(autor);
        cardleft.appendChild(linkTitle);
        cardleft.appendChild(newsContent);
        
        const cardright = document.createElement("div");
        cardright.setAttribute("class", "card-right");
        
        const newsImage = document.createElement("img");
        newsImage.src = this.getAttribute("img-url") || "assets/null.png";
        newsImage.alt = this.getAttribute("text-alt");
        cardright.appendChild(newsImage);
        
        componentRoot.appendChild(cardleft);
        componentRoot.appendChild(cardright);

        return componentRoot;
    }

    style(){
        const style = document.createElement("style");
        style.textContent = `
        .card{
            display: flex;
            flex-direction: row;
            justify-content: space-between;
            width: 100%;
            margin: 25px;
            
            border: solid #000 3px;
            -webkit-box-shadow: 15px 17px 19px -10px rgba(0,0,0,0.75);
            -moz-box-shadow: 15px 17px 19px -10px rgba(0,0,0,0.75);
            box-shadow: 15px 17px 19px -10px rgba(0,0,0,0.75);
        }
        
        .card-left{
            // border: solid #00f 3px; 
            display: flex;
            flex-direction: column;
            justify-content: center;
            padding-left: 10px;
            // background-color: #5ca78c;
        }
        
        .card-left > a {
            margin-top: 15px;
            font-size: 30px;
            text-decoration: none;
            color: #000;
        }
        
        .card-left > p {
            color: rgb(70, 70, 70);
        }
        
        .card-left > span{
            font-weight: bold;
        }
        
        
        .card-right > img{
            width: 450px;
        }
        
        `
        return style
    }

}

customElements.define('card-news', CardNews) // definindo o nome do elemento