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
let velocidadeRaquete = 5;

let xRaquete2 = 580;
let yRaquete2 = 150;
let velocidadeRaquete2 = 5;

let pontosJogador1 = 0;
let pontosJogador2 = 0;

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
    moverBolinha();
    validarColisaoBorda();
    criarRaquete(xRaquete, yRaquete);
    criarRaquete(xRaquete2, yRaquete2);
    moverRaquete();
    moverRaquete2();
    validarColisaoRaquete(xRaquete, yRaquete);
    validarColisaoRaquete(xRaquete2, yRaquete2);
    exibirPlacar();
}

function criarBolinha() {
    circle(xBolinha, yBolinha, diametro);
}

function moverBolinha() {
    xBolinha += vxBolinha;
    yBolinha += vyBolinha;
}

function validarColisaoBorda() {
    if (xBolinha + raio > width) {
        pontosJogador1++;
        resetBolinha();
    } else if (xBolinha - raio < 0) {
        pontosJogador2++;
        resetBolinha();
    }

    if (yBolinha + raio > height || yBolinha - raio < 0) {
        vyBolinha *= -1;
    }
}

function criarRaquete(x, y) {
    rect(x, y, larguraRaquete, alturaRaquete);
}

function moverRaquete() {
    if (keyIsDown(UP_ARROW)) {
        yRaquete -= velocidadeRaquete;
    }
    if (keyIsDown(DOWN_ARROW)) {
        yRaquete += velocidadeRaquete;
    }
    yRaquete = constrain(yRaquete, 0, height - alturaRaquete);
}

function moverRaquete2() {
    if (keyIsDown(87)) { // 'W'
        yRaquete2 -= velocidadeRaquete2;
    }
    if (keyIsDown(83)) { // 'S'
        yRaquete2 += velocidadeRaquete2;
    }
    yRaquete2 = constrain(yRaquete2, 0, height - alturaRaquete);
}

function validarColisaoRaquete(x, y) {
    if (
        xBolinha - raio < x + larguraRaquete &&
        xBolinha + raio > x &&
        yBolinha > y &&
        yBolinha < y + alturaRaquete
    ) {
        vxBolinha *= -1;
    }
}

function resetBolinha() {
    xBolinha = width / 2;
    yBolinha = height / 2;
    vxBolinha = random(4, 10) * (random() > 0.5 ? 1 : -1);
    vyBolinha = random(4, 10) * (random() > 0.5 ? 1 : -1);
}

function exibirPlacar() {
    fill(255);
    textSize(20);
    textAlign(CENTER, TOP);
    text(pontosJogador1, width / 4, 20);
    text(pontosJogador2, (3 * width) / 4, 20);
}
