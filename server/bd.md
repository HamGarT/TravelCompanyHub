TravelHour (
  id INT PRIMARY KEY,
  hour TIME,
  date DATE,
  idBan INT,
  idDriver INT,
  idRoute INT,
  FOREIGN KEY (idBan) REFERENCES Bans(id),
  FOREIGN KEY (idDriver) REFERENCES Driver(id),
  FOREIGN KEY (idRoute) REFERENCES Routes(id)
)

User (
  id INT PRIMARY KEY,
  name VARCHAR(100),
  dni VARCHAR(50),
  email VARCHAR(100),
  phone_number VARCHAR(20),
  role ENUM('passenger', 'admin', 'driver')
)
Bans (
  id INT PRIMARY KEY,
  model VARCHAR(100),
  image VARCHAR(255),
  placard VARCHAR(50),
  seats INT,
  year YEAR,
  idCompany INT,
  FOREIGN KEY (idCompany) REFERENCES Company(id)
)

Driver (
  id INT PRIMARY KEY,
  names VARCHAR(100),
  lastnames VARCHAR(100),
  dni VARCHAR(50),
  phone_number VARCHAR(20),
  photo VARCHAR(255),
  license VARCHAR(50),
  stars DECIMAL(3, 2),
  idCompany INT,
  FOREIGN KEY (idCompany) REFERENCES Company(id)
)

Passage (
  id INT PRIMARY KEY,
  price DECIMAL(10, 2),
  seat_number INT,
  passenger_dni VARCHAR(50),
  passenger_name VARCHAR(100),
  status ENUM('paid', 'not paid'),
  purchase_date DATE,
  idUser INT,
  idBan INT,
  FOREIGN KEY (idUser) REFERENCES User(id),
  FOREIGN KEY (idBan) REFERENCES Bans(id)
)

Company (
  id INT PRIMARY KEY,
  name VARCHAR(100),
  contact_information TEXT,
  address VARCHAR(255),
  opening_hours TIME,
  closing_hours TIME
)

Routes (
  id INT PRIMARY KEY,
  origin VARCHAR(100),
  destination VARCHAR(100),
  distance DECIMAL(10, 2),
  estimated_duration TIME
)

Payments (
  id INT PRIMARY KEY,
  payment_method ENUM('credit card', 'cash', 'online transfer'),
  payment_status ENUM('successful', 'pending', 'failed'),
  transaction_id VARCHAR(100),
  passage_id INT,
  FOREIGN KEY (passage_id) REFERENCES Passage(id)
)

Reviews (
  id INT PRIMARY KEY,
  review_text TEXT,
  rating DECIMAL(3, 2),
  idUser INT,
  idDriver INT,
  idCompany INT,
  FOREIGN KEY (idUser) REFERENCES User(id),
  FOREIGN KEY (idDriver) REFERENCES Driver(id),
  FOREIGN KEY (idCompany) REFERENCES Company(id)
)

Schedules (
  id INT PRIMARY KEY,
  travel_hour_id INT,
  departure_time TIME,
  arrival_time TIME,
  FOREIGN KEY (travel_hour_id) REFERENCES TravelHour(id)
)