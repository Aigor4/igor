document.addEventListener('keydown', moveCar);

const car1 = document.getElementById('car1');
let car1Pos = { x: 10, y: 10 };
let car1Speed = { x: 0, y: 0 };

function moveCar(e) {
    switch (e.keyCode) {
        case 39: // Strzałka w prawo
            car1Speed = { x: 5, y: 0 };
            break;
        case 37: // Strzałka w lewo
            car1Speed = { x: -5, y: 0 };
            break;
        case 38: // Strzałka w górę
            car1Speed = { x: 0, y: -5 };
            break;
        case 40: // Strzałka w dół
            car1Speed = { x: 0, y: 5 };
            break;
    }
}

function updateGameArea() {
    car1Pos.x += car1Speed.x;
    car1Pos.y += car1Speed.y;

    car1Pos.x = Math.max(0, Math.min(car1Pos.x, 950));
    car1Pos.y = Math.max(0, Math.min(car1Pos.y, 950));

    car1.style.left = car1Pos.x + 'px';
    car1.style.top = car1Pos.y + 'px';

    // Sprawdzenie, czy samochód przekroczył linię mety
    if (car1Pos.y >= 950 && car1Pos.x >= 950) {
        alert('Przekroczyłeś linię mety!');
    }

    requestAnimationFrame(updateGameArea);
}

updateGameArea();
