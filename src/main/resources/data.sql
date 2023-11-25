DROP TABLE IF EXISTS article;
DROP TABLE IF EXISTS category;
 
CREATE TABLE article (
  id INT AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(250) NOT NULL,
  stock_quantity INTEGER NOT NULL,
  short_description VARCHAR(250) NOT NULL,
  long_description VARCHAR(250) NOT NULL,
  category_id VARCHAR(250) NOT NULL
);

CREATE TABLE category (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  name VARCHAR(250) NOT NULL
);
 
INSERT INTO category (name) VALUES
  ('Technologie'),
  ('Nourriture'),
  ('Décoration');

INSERT INTO article (name, stock_quantity, short_description, long_description, category_id) VALUES
  ('Souris', 14, 'souris Corsair MG50', 'Cette souris Corsair est maniable et adaptée à votre main. Elle possède 12 boutons sur le côté, très utiles pour les jeux vidéos.', 1),
  ('Clavier', 51, 'Clavier Razor 72 touches', 'Clavier 72 touches, il possède un rétro-éclairage des touches, ce qui pourra vous permettre de continuer son utilisation même avec très peu de luminosité dans votre environnement. Disponible en AZERTY ou en QWERTY. Disponible en BEPO sous commande.', 1),
  ('Baguette de pain', 128, 'Baguette paysanne', 'Cette baguette paysanne saura vous satisfaire avec sa mie de pain tendre et savoureuse. Confectionnée à partir de farine de blé. Liste des allergènes sur demande.', 2),
  ('Lampe', 5, 'Lampe de chevet décorative', 'Cette lampe de chevet est décorative. Elle saura se fondre parfaitement dans le décor d''une chambre d''enfant par exemple. Elle permet d''utiliser plusieurs niveaux de luminosité.', 3)
;