let xBolinha = 300;
let yBolinha = 200;
let diametro = 30;
let vxBolinha;
let vyBolinha;
let raio = diametro / 2;

let xRaquete = 10;
let yRaquete = 150;
let larguraRaquete = 10;
let alturaRaquete = 100;

    function setup() {
        createCanvas(600, 400);

        vxBolinha = random(4, 10);
        vyBolinha = random(4, 10);

        if (random() > 0.5) vxBolinha *= -1;
        if (random() > 0.5) vyBolinha *= -1;
    }

function draw() {
    background(0);
    criarBolinha();
    vBolinha();
    validarColisaoBorda();
    criarRaquete();

    function criarBolinha() {
        circle(xBolinha, yBolinha, diametro);
    }

    function vBolinha() {
        xBolinha += vxBolinha;
        yBolinha += vyBolinha;
    }

    function validarColisaoBorda() {
        if (xBolinha + raio > width || xBolinha - raio < 0) {
            vxBolinha *= -1;
        }

        if (yBolinha + raio > height || yBolinha - raio < 0) {
            vyBolinha *= -1;
        }
    }

    
    function criarRaquete() {
        rect(xRaquete, yRaquete, larguraRaquete, alturaRaquete);
    }

    function validarColisaoRaquete() {
        if (xBolinha - raio < xRaquete + larguraRaquete 
            && yBolinha > yRaquete && yBolinha)
    }


}