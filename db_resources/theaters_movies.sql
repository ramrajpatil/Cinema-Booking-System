-- Cinepolis
INSERT INTO theaters_movies (theater_id, movie_id) VALUES
(1, 1),  -- John Wick
(1, 5),  -- Top Gun
(1, 7),  -- Iron Man
(1, 10); -- Shawshank Redemption

-- Citypride Deccan
INSERT INTO theaters_movies (theater_id, movie_id) VALUES
(2, 2),  -- John Wick Chapter 2
(2, 6),  -- Top Gun: Maverick
(2, 8),  -- Iron Man 2
(2, 11); -- The Avengers

-- PVR Icon
INSERT INTO theaters_movies (theater_id, movie_id) VALUES
(3, 3),  -- John Wick Chapter 3
(3, 9),  -- Iron Man 3
(3, 10), -- Shawshank Redemption
(3, 11); -- The Avengers

-- Citypride Mangala
INSERT INTO theaters_movies (theater_id, movie_id) VALUES
(4, 4),  -- John Wick Chapter 4
(4, 5),  -- Top Gun
(4, 8),  -- Iron Man 2
(4, 10); -- Shawshank Redemption

-- PVR Theater
INSERT INTO theaters_movies (theater_id, movie_id) VALUES
(5, 6),  -- Top Gun: Maverick
(5, 7),  -- Iron Man
(5, 9),  -- Iron Man 3
(5, 11); -- The Avengers

-- Padma Talkies
INSERT INTO theaters_movies (theater_id, movie_id) VALUES
(6, 1),  -- John Wick
(6, 2),  -- John Wick Chapter 2
(6, 9),  -- Iron Man 3
(6, 10); -- Shawshank Redemption

-- Inox Theater
INSERT INTO theaters_movies (theater_id, movie_id) VALUES
(7, 3),  -- John Wick Chapter 3
(7, 4),  -- John Wick Chapter 4
(7, 6),  -- Top Gun: Maverick
(7, 11); -- The Avengers

-- Maratha Mandir
INSERT INTO theaters_movies (theater_id, movie_id) VALUES
(8, 5),  -- Top Gun
(8, 7),  -- Iron Man
(8, 10), -- Shawshank Redemption
(8, 11); -- The Avengers

-- Carnival Cinemas
INSERT INTO theaters_movies (theater_id, movie_id) VALUES
(9, 1),  -- John Wick
(9, 3),  -- John Wick Chapter 3
(9, 5),  -- Top Gun
(9, 9);  -- Iron Man 3

-- Anand Chitramandir
INSERT INTO theaters_movies (theater_id, movie_id) VALUES
(11, 2), -- John Wick Chapter 2
(11, 4), -- John Wick Chapter 4
(11, 7), -- Iron Man
(11, 10);-- Shawshank Redemption

-- SFC Cinemas
INSERT INTO theaters_movies (theater_id, movie_id) VALUES
(12, 1),  -- John Wick
(12, 6),  -- Top Gun: Maverick
(12, 8),  -- Iron Man 2
(12, 11); -- The Avengers

-- 7 Star Cinemas
INSERT INTO theaters_movies (theater_id, movie_id) VALUES
(13, 2),  -- John Wick Chapter 2
(13, 4),  -- John Wick Chapter 4
(13, 6),  -- Top Gun: Maverick
(13, 9);  -- Iron Man 3

-- Rajlakshmi Theater
INSERT INTO theaters_movies (theater_id, movie_id) VALUES
(14, 3),  -- John Wick Chapter 3
(14, 5),  -- Top Gun
(14, 9),  -- Iron Man 3
(14, 11); -- The Avengers

-- RK Cinemas
INSERT INTO theaters_movies (theater_id, movie_id) VALUES
(15, 1),  -- John Wick
(15, 7),  -- Iron Man
(15, 10), -- Shawshank Redemption
(15, 11); -- The Avengers

-- Movie Max
INSERT INTO theaters_movies (theater_id, movie_id) VALUES
(16, 2),  -- John Wick Chapter 2
(16, 3),  -- John Wick Chapter 3
(16, 6),  -- Top Gun: Maverick
(16, 8);  -- Iron Man 2

-- RK Cinemas
INSERT INTO theaters_movies (theater_id, movie_id) VALUES
(17, 4),  -- John Wick Chapter 4
(17, 7),  -- Iron Man
(17, 9),  -- Iron Man 3
(17, 10); -- Shawshank Redemption


mysql> select m.title, t.theater_name from movies m
    -> inner join theaters_movies tm on m.id=tm.movie_id
    -> inner join theaters t on tm.theater_id=t.id;
/*
+----------------------+--------------------+
| title                | theater_name       |
+----------------------+--------------------+
| John Wick            | cinepolis          |
| John Wick            | padma_talkies      |
| John Wick            | carnival_cinemas   |
| John Wick            | sfc_cinemas        |
| John Wick            | rk_cinemas         |
| John Wick Chapter 2  | citypride_deccan   |
| John Wick Chapter 2  | padma_talkies      |
| John Wick Chapter 2  | anand_chitramandir |
| John Wick Chapter 2  | 7_star_cinemas     |
| John Wick Chapter 2  | pvr_cinemas        |
| John Wick Chapter 3  | pvr_icon           |
| John Wick Chapter 3  | inox_theater       |
| John Wick Chapter 3  | carnival_cinemas   |
| John Wick Chapter 3  | rajlakshmi_theater |
| John Wick Chapter 3  | pvr_cinemas        |
| John Wick Chapter 4  | citypride_mangala  |
| John Wick Chapter 4  | inox_theater       |
| John Wick Chapter 4  | anand_chitramandir |
| John Wick Chapter 4  | 7_star_cinemas     |
| John Wick Chapter 4  | movie_max          |
| Top Gun              | cinepolis          |
| Top Gun              | citypride_mangala  |
| Top Gun              | maratha_mandir     |
| Top Gun              | carnival_cinemas   |
| Top Gun              | rajlakshmi_theater |
| Top Gun: Maverick    | citypride_deccan   |
| Top Gun: Maverick    | pvr_theater        |
| Top Gun: Maverick    | inox_theater       |
| Top Gun: Maverick    | sfc_cinemas        |
| Top Gun: Maverick    | 7_star_cinemas     |
| Top Gun: Maverick    | pvr_cinemas        |
| Iron Man             | cinepolis          |
| Iron Man             | pvr_theater        |
| Iron Man             | maratha_mandir     |
| Iron Man             | anand_chitramandir |
| Iron Man             | rk_cinemas         |
| Iron Man             | movie_max          |
| Iron Man 2           | citypride_deccan   |
| Iron Man 2           | citypride_mangala  |
| Iron Man 2           | sfc_cinemas        |
| Iron Man 2           | pvr_cinemas        |
| Iron Man 3           | pvr_icon           |
| Iron Man 3           | pvr_theater        |
| Iron Man 3           | padma_talkies      |
| Iron Man 3           | carnival_cinemas   |
| Iron Man 3           | 7_star_cinemas     |
| Iron Man 3           | rajlakshmi_theater |
| Iron Man 3           | movie_max          |
| Shawshank Redemption | cinepolis          |
| Shawshank Redemption | pvr_icon           |
| Shawshank Redemption | citypride_mangala  |
| Shawshank Redemption | padma_talkies      |
| Shawshank Redemption | maratha_mandir     |
| Shawshank Redemption | anand_chitramandir |
| Shawshank Redemption | rk_cinemas         |
| Shawshank Redemption | movie_max          |
| The Avengers         | citypride_deccan   |
| The Avengers         | pvr_icon           |
| The Avengers         | pvr_theater        |
| The Avengers         | inox_theater       |
| The Avengers         | maratha_mandir     |
| The Avengers         | sfc_cinemas        |
| The Avengers         | rajlakshmi_theater |
| The Avengers         | rk_cinemas         |
+----------------------+--------------------+
64 rows in set (0.00 sec)
*/
