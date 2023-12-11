document.addEventListener('keydown', moveCar);

const car1 = document.getElementById('car1');
const car2 = document.getElementById('car2');
let car1Pos = 10;
let car2Pos = 10;
let car1Speed = 0;
let car2Speed = Math.random() * 5 + 1;
let car1Direction = 'right';
let car2Direction = 'right';

function moveCar(e) {
    if (e.keyCode === 39) { // Strzałka w prawo
        car1Speed = 5;
    }
    if (e.keyCode === 37) { // Strzałka w lewo
        car1Speed = -5;
    }
}

function updateGameArea() {
    if (car1Direction === 'right') {
        car1Pos += car1Speed;
    } else {
        car1Pos -= car1Speed;
    }

    if (car2Direction === 'right') {
        car2Pos += car2Speed;
    } else {
        car2Pos -= car2Speed;
    }

    // Zmiana kierunku na zakrętach
    if (car1Pos > 350 && car1Direction === 'right') {
        car1Direction = 'left';
    } else if (car1Pos < 50 && car1Direction === 'left') {
        car1Direction = 'right';
    }

    if (car2Pos > 350 && car2Direction === 'right') {
        car2Direction = 'left';
    } else if (car2Pos < 50 && car2Direction === 'left') {
        car2Direction = 'right';
    }

    if (car1Pos < 0) car1Pos = 0;
    if (car1Pos > 750 || car2Pos > 750) {
        let winner = car1Pos > car2Pos ? 'Czerwony samochód wygrywa!' : 'Niebieski samochód wygrywa!';
        alert(winner);
        resetGame();
        return;
    }

    car1.style.left = car1Pos + 'px';
    car2.style.left = car2Pos + 'px';

    requestAnimationFrame(updateGameArea);
}

function resetGame() {
    car1Pos = 10;
    car2Pos = 10;
    car1Speed = 0;
    car2Speed = Math.random() * 5 + 1;
    car1Direction = 'right';
    car2Direction = 'right';
}

updateGameArea();
