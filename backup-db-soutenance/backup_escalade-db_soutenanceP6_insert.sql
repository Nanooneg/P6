-- INSERT FOR ESCALADE DATABASE --

--
-- TOC entry 2961 (class 0 OID 59349)
-- Dependencies: 196
-- Data for Name: account; Type: TABLE DATA; Schema: public; Owner: nanoo
--

INSERT INTO public.account (id, city, date_of_creation, date_of_update, firstname, lastname, mail, password, postal_code, role_name, street_name, title) VALUES (5, NULL, '2019-11-04 10:04:40.223', '2019-11-04 10:04:40.223', 'User3', 'User3', 'user3@mail.fr', '/rvt2t868LZicOTYSwkgsZwm3Gl3W+8TXV4zdmDWsPTxVcY1kQfiUQ==', 0, 'User', NULL, 'N/C');
INSERT INTO public.account (id, city, date_of_creation, date_of_update, firstname, lastname, mail, password, postal_code, role_name, street_name, title) VALUES (3, NULL, '2019-11-04 10:03:48.646', '2019-11-04 10:03:48.651', 'Admin', 'Admin', 'admin@mail.fr', '/OKOiDXBqKtbvhLGNWklL80jvXJTPzgZ4vF3j77RqC550M7YfiUpWA==', 0, 'Admin', NULL, 'N/C');
INSERT INTO public.account (id, city, date_of_creation, date_of_update, firstname, lastname, mail, password, postal_code, role_name, street_name, title) VALUES (1, NULL, '2019-11-04 10:02:50.125', '2019-11-04 10:22:39.062', 'User', 'User', 'user@mail.fr', 'WgxRmWGg2ihCztwMqYkYhDl/u4pvUBG1WZMw9feR1OkAN5KBuOjjMA==', 0, 'User', NULL, 'N/C');
INSERT INTO public.account (id, city, date_of_creation, date_of_update, firstname, lastname, mail, password, postal_code, role_name, street_name, title) VALUES (2, NULL, '2019-11-04 10:03:15.497', '2019-11-10 14:59:32.777', 'Membre', 'Membre', 'membre@mail.fr', 'ad+0QVQLQevGbDrD6ZMjdW3MNqhcPE6Va7O52xDv+V3Wz8kN+phGpA==', 0, 'Member', NULL, 'N/C');
INSERT INTO public.account (id, city, date_of_creation, date_of_update, firstname, lastname, mail, password, postal_code, role_name, street_name, title) VALUES (4, NULL, '2019-11-04 10:04:20.425', '2019-11-11 15:58:55.228', 'User2', 'User2', 'user2@mail.fr', 'G0xrqzJGnIv++c4laLTGTAfrtYsjoibgZrDlvsDndxbnQhlyn443FQ==', 0, 'User', NULL, 'N/C');



--
-- TOC entry 2964 (class 0 OID 59367)
-- Dependencies: 199
-- Data for Name: site; Type: TABLE DATA; Schema: public; Owner: nanoo
--

INSERT INTO public.site (id, date_of_creation, date_of_update, description, id_account, name, is_official_label, picture_path, region) VALUES (68, '2019-11-05 15:23:21.391', '2019-11-05 15:23:21.391', 'Valdu di Saltu, c’est LE site de bloc récent et en plein développement dans le sud de la Corse, quelque part entre Ajaccio et Propriano. C’est déjà le plus gros spot de bloc de l’île et il se caractérise par… son très gros potentiel.', 4, 'Valdu Di Saltu', false, '/resources/site/Tue_Nov_05_15_23_21_CET_2019_Valdu_Di_Saltu.jpg', 'Corse');
INSERT INTO public.site (id, date_of_creation, date_of_update, description, id_account, name, is_official_label, picture_path, region) VALUES (69, '2019-11-05 15:25:17.821', '2019-11-05 15:25:17.821', 'Qui dit «Punta» en Corse, dit déjà pour sûr, mer bleue, et ici, langue de terre d’environ un kilomètre qui pénètre dans la mer, desservie uniquement par une piste.', 4, 'Punta di Capineru', false, '/resources/site/Tue_Nov_05_15_25_17_CET_2019_Punta_di_Capineru.jpg', 'Corse');
INSERT INTO public.site (id, date_of_creation, date_of_update, description, id_account, name, is_official_label, picture_path, region) VALUES (6, '2019-11-04 13:19:09.359', '2019-11-05 15:26:03.125', 'Le Verdon, c''est la falaise de tous les superlatifs, le seule, l’unique, la vraie, c’est celle-là. Madame "plus". La plus grande, la plus belle, la plus vertigineuse, la plus mythique, la plus grise, la plus blanche, la plus sauvage, la plus fréquentée, la plus fascinante, la plus inoubliable...', 1, 'Gorges du Verdon', true, '/resources/site/Mon_Nov_04_13_19_09_CET_2019_L''Escalès_(Gorges_du_verdon).jpg', 'Paca');
INSERT INTO public.site (id, date_of_creation, date_of_update, description, id_account, name, is_official_label, picture_path, region) VALUES (42, '2019-11-04 22:38:58.31', '2019-11-05 15:26:15.32', 'Sormiou est une Calanque vivante : proche de Marseille, accessible en voiture, s''y nichent un petit port entouré de cabanons et une assez grande plage. Les secteurs de grimpe y sont très nombreux et fréquentés : beaucoup de couennes, parfois des deuxièmes longueurs, peu de voies de plusieurs longueu', 4, 'Les calanques de Sormiou', true, '/resources/site/Mon_Nov_04_22_40_24_CET_2019_Les_calanques_de_Sormiou.jpg', 'Paca');
INSERT INTO public.site (id, date_of_creation, date_of_update, description, id_account, name, is_official_label, picture_path, region) VALUES (30, '2019-11-04 22:19:55.19', '2019-11-05 15:26:28.352', 'Buoux, c’est un terreau où ont poussé des voies d’exception, où ont grandi des grimpeurs hors norme, où s’est écrit le grand feuilleton à suspense de l’escalade. Il y a quelque chose de magique et d’initiatique dans ce caillou. Peut-être même d’envoûtant...', 1, 'Buoux', true, '/resources/site/Mon_Nov_04_22_21_15_CET_2019_Buoux.jpg', 'Paca');
INSERT INTO public.site (id, date_of_creation, date_of_update, description, id_account, name, is_official_label, picture_path, region) VALUES (67, '2019-11-05 15:17:21.216', '2019-11-11 17:20:05.166', 'Dans le massif de Bavella poussent des aiguilles de granit rouge moucheté de lichen jaune dont la base se perd dans des vallons touffus. Elles composent un décor extravagant, avec parfois un peu de brume façon baie d’Along, ou des pins suspendus façon Japon. Dépaysement assuré!', 4, 'Bavella', false, '/resources/site/Tue_Nov_05_15_17_21_CET_2019_Bavella.jpg', 'Corse');



--
-- TOC entry 2963 (class 0 OID 59359)
-- Dependencies: 198
-- Data for Name: sector; Type: TABLE DATA; Schema: public; Owner: nanoo
--

INSERT INTO public.sector (id, date_of_creation, date_of_update, description, id_account, name, id_site) VALUES (7, '2019-11-04 13:21:40.369', '2019-11-04 13:21:40.371', 'La paroi de l’Escalès constitue la falaise reine des gorges du Verdon. Bien que d’autres soient aussi belles, aussi hautes et aussi élancées (voir plus), la paroi de l’Escalès réunit presque tout ce qui se fait de mieux au Verdon.', 1, 'L''escalès', 6);
INSERT INTO public.sector (id, date_of_creation, date_of_update, description, id_account, name, id_site) VALUES (15, '2019-11-04 13:47:55.791', '2019-11-04 13:47:55.792', '50 lignes, cotations 5b 8c, conditions et commerces sur place à La Palud-sur-Verdon.', 1, 'Hulk (paroi du duc)', 6);
INSERT INTO public.sector (id, date_of_creation, date_of_update, description, id_account, name, id_site) VALUES (22, '2019-11-04 14:02:38.313', '2019-11-04 14:02:38.313', 'Classique abordable (surtout en évitant les deux premières longueurs) et peu gazeuse, descente à pied. Parfait pour emmener des non grimpeurs de grande voie, si on évite les deux premières longueurs. Vue imprenable !!', 1, 'L''arrête du Belvédère', 6);
INSERT INTO public.sector (id, date_of_creation, date_of_update, description, id_account, name, id_site) VALUES (31, '2019-11-04 22:23:01.526', '2019-11-04 22:23:01.527', 'Le pilier des fourmis évoquera pour beaucoup la célèbre ligne de Buoux, immortalisée par le célèbre Patrick Edlinger, grimpant le haut du dernier 7a dans son film « la vie au bout des doigts ».', 1, 'Le pilier des fourmis', 30);
INSERT INTO public.sector (id, date_of_creation, date_of_update, description, id_account, name, id_site) VALUES (37, '2019-11-04 22:33:08.125', '2019-11-04 22:33:08.125', 'Proue caractéristique située à gauche du mur du Styx, ce secteur offre quelques-unes des plus belles voies de la falaise.', 1, 'Le nombril', 30);
INSERT INTO public.sector (id, date_of_creation, date_of_update, description, id_account, name, id_site) VALUES (43, '2019-11-04 22:42:02.98', '2019-11-04 22:42:02.981', 'Voie récente ouverte sur le secteur Archipel : 4 longueurs faciles qui permettent de rejoindre la crête sur un caillou exceptionnel de grip mais encore fragile.', 4, 'The big Lebowsky', 42);
INSERT INTO public.sector (id, date_of_creation, date_of_update, description, id_account, name, id_site) VALUES (48, '2019-11-04 22:44:15.783', '2019-11-04 22:44:15.783', 'Depuis la calanque de Sormiou, suivre le sentier côtier jusqu''au Cap Redon, sur la droite en regardant la mer, depuis la plage.', 4, 'Cap Redon', 42);
INSERT INTO public.sector (id, date_of_creation, date_of_update, description, id_account, name, id_site) VALUES (49, '2019-11-04 22:45:30.499', '2019-11-04 22:45:44.35', 'Lieu agréable dans le vallon verdoyant situé juste au pied du Col de Sormiou. 10min de marches par le Col de Lun offre une belle vue sur la calanques de Sormiou et plus encore.', 4, 'Colline de Lun (face W)', 42);
INSERT INTO public.sector (id, date_of_creation, date_of_update, description, id_account, name, id_site) VALUES (50, '2019-11-04 22:45:59.068', '2019-11-04 22:45:59.068', 'Lieu agréable dans le vallon verdoyant situé juste au pied du Col de Sormiou. 10min de marches par le Col de Lun offre une belle vue sur la calanques de Sormiou et plus encore.', 4, 'Colline de Lun (face S)', 42);
INSERT INTO public.sector (id, date_of_creation, date_of_update, description, id_account, name, id_site) VALUES (59, '2019-11-04 22:52:13.814', '2019-11-04 22:52:13.814', 'Au col, on voit sur la droite (en regardant la mer) et assez bas un petit cairn sur un éperon qui marque la sortie d''un couloir. Viser ce cairn en prenant son temps pour trouver les bons passages sans massacrer la végétation.', 4, 'Rumpe Cuou', 42);
INSERT INTO public.sector (id, date_of_creation, date_of_update, description, id_account, name, id_site) VALUES (64, '2019-11-05 15:00:07.146', '2019-11-05 15:00:07.146', 'Petit secteur (3 voies d''une longueur et 3 voies de deux longueurs) en face SW du Bec de Sormiou, à D du Dièdre Guem, au-dessus du secteur Archipel. Attention, les voies s''atteignent par le haut, avec un rappel de 45 m, et les pieds de voies sont une vire discontinues au mieux de 50cm.', 4, 'Le Conglué', 42);
INSERT INTO public.sector (id, date_of_creation, date_of_update, description, id_account, name, id_site) VALUES (65, '2019-11-05 15:01:02.193', '2019-11-05 15:01:02.193', 'De part et d''autre du col et de la route, 2 faces : l''une regardant Marseille, l''autre tournée vers le large.
Escalade sur dalles bien équipées et de faible hauteur, pour l''initiation.', 4, 'Le col de Sormiou', 42);
INSERT INTO public.sector (id, date_of_creation, date_of_update, description, id_account, name, id_site) VALUES (70, '2019-11-05 16:22:54.007', '2019-11-05 16:22:54.008', 'Approche : Parking 100m sous la base Corsica Canyon sur un accotement à droite en venant du col de Bavella. Descendre la route sur environ 120m jusqu’au regard d’écoulement (N°35 à la peinture blanche).', 4, 'Secteur 3G', 67);



--
-- TOC entry 2965 (class 0 OID 59375)
-- Dependencies: 200
-- Data for Name: topo; Type: TABLE DATA; Schema: public; Owner: nanoo
--

INSERT INTO public.topo (id, date_of_creation, date_of_update, description, id_account, name, condition, date_of_publication, is_lendable, picture_path, region) VALUES (72, '2019-11-05 16:44:06.969', '2019-11-05 16:44:06.969', 'C’est un site de référence, surtout pour sa grotte qui compte pas moins de 17 voies dans le 8 (du 8a au 8C+ !!!!)', 1, 'Bléone - Durance', 'Neuf', '2019-11-01', false, '/resources/topo/Tue_Nov_05_16_44_06_CET_2019_Bléone_-_Durance.jpg', 'Paca');
INSERT INTO public.topo (id, date_of_creation, date_of_update, description, id_account, name, condition, date_of_publication, is_lendable, picture_path, region) VALUES (73, '2019-11-05 16:46:27.537', '2019-11-05 16:54:52.425', 'L’île de la Réunion est un paradis pour les sports outdoor comme l’escalade. Mais elle possède également les plus beaux canyons qui soient, nous ferons également un petit aperçu prochainement .', 1, 'Topo falaise', 'Neuf', '2019-01-17', false, '/resources/topo/Tue_Nov_05_16_46_27_CET_2019_Topo_falaise.jpg', 'Réunion');
INSERT INTO public.topo (id, date_of_creation, date_of_update, description, id_account, name, condition, date_of_publication, is_lendable, picture_path, region) VALUES (71, '2019-11-05 16:37:33.625', '2019-11-05 16:50:01.945', 'Retrouvez dans cette 3ème édition du topo EST''CALADES les principales falaises des Vosges du Sud.', 1, 'Est''Calade', 'Bon état', '2018-03-02', false, '/resources/topo/Tue_Nov_05_16_37_33_CET_2019_Est''Calade.jpg', 'Grand-Est');



--
-- TOC entry 2967 (class 0 OID 59388)
-- Dependencies: 202
-- Data for Name: way; Type: TABLE DATA; Schema: public; Owner: nanoo
--

INSERT INTO public.way (id, date_of_creation, date_of_update, description, id_account, name, anchor_nbr, height, pitch_nbr, rating, rating_level, id_sector) VALUES (9, '2019-11-04 13:28:11.046', '2019-11-04 13:28:11.046', NULL, 1, 'Pichenibule', 69, 94, 2, '6c', 11, 7);
INSERT INTO public.way (id, date_of_creation, date_of_update, description, id_account, name, anchor_nbr, height, pitch_nbr, rating, rating_level, id_sector) VALUES (8, '2019-11-04 13:27:18.201', '2019-11-04 13:28:22.111', NULL, 1, 'Dingomaniaque', 61, 80, 2, '6b', 10, 7);
INSERT INTO public.way (id, date_of_creation, date_of_update, description, id_account, name, anchor_nbr, height, pitch_nbr, rating, rating_level, id_sector) VALUES (10, '2019-11-04 13:32:03.187', '2019-11-04 13:32:03.187', NULL, 1, 'Fenrir', 71, 94, 2, '7a', 12, 7);
INSERT INTO public.way (id, date_of_creation, date_of_update, description, id_account, name, anchor_nbr, height, pitch_nbr, rating, rating_level, id_sector) VALUES (11, '2019-11-04 13:34:01.611', '2019-11-04 13:34:01.611', NULL, 1, 'Caca boudin', 61, 78, 2, '7a', 12, 7);
INSERT INTO public.way (id, date_of_creation, date_of_update, description, id_account, name, anchor_nbr, height, pitch_nbr, rating, rating_level, id_sector) VALUES (12, '2019-11-04 13:35:40.73', '2019-11-04 13:35:40.73', NULL, 1, 'Polpot', 53, 84, 2, '7c', 14, 7);
INSERT INTO public.way (id, date_of_creation, date_of_update, description, id_account, name, anchor_nbr, height, pitch_nbr, rating, rating_level, id_sector) VALUES (13, '2019-11-04 13:36:48.862', '2019-11-04 13:36:48.862', NULL, 1, 'Séance tenante', 81, 113, 3, '8a', 15, 7);
INSERT INTO public.way (id, date_of_creation, date_of_update, description, id_account, name, anchor_nbr, height, pitch_nbr, rating, rating_level, id_sector) VALUES (14, '2019-11-04 13:38:03.328', '2019-11-04 13:39:59.7', NULL, 1, 'Red', 78, 110, 3, '8c', 17, 7);
INSERT INTO public.way (id, date_of_creation, date_of_update, description, id_account, name, anchor_nbr, height, pitch_nbr, rating, rating_level, id_sector) VALUES (16, '2019-11-04 13:51:47.933', '2019-11-04 13:51:47.933', NULL, 1, 'L1', 35, 51, 1, '6c', 11, 15);
INSERT INTO public.way (id, date_of_creation, date_of_update, description, id_account, name, anchor_nbr, height, pitch_nbr, rating, rating_level, id_sector) VALUES (17, '2019-11-04 13:52:16.206', '2019-11-04 13:52:16.206', NULL, 1, 'L2', 37, 55, 1, '6b', 10, 15);
INSERT INTO public.way (id, date_of_creation, date_of_update, description, id_account, name, anchor_nbr, height, pitch_nbr, rating, rating_level, id_sector) VALUES (18, '2019-11-04 13:52:34.731', '2019-11-04 13:52:34.731', NULL, 1, 'L3', 31, 50, 1, '6c', 11, 15);
INSERT INTO public.way (id, date_of_creation, date_of_update, description, id_account, name, anchor_nbr, height, pitch_nbr, rating, rating_level, id_sector) VALUES (19, '2019-11-04 13:55:11.865', '2019-11-04 13:55:11.865', NULL, 1, 'L4', 32, 49, 1, '6b', 10, 15);
INSERT INTO public.way (id, date_of_creation, date_of_update, description, id_account, name, anchor_nbr, height, pitch_nbr, rating, rating_level, id_sector) VALUES (20, '2019-11-04 13:55:31.699', '2019-11-04 13:55:31.699', NULL, 1, 'L5', 38, 50, 1, '5a', 6, 15);
INSERT INTO public.way (id, date_of_creation, date_of_update, description, id_account, name, anchor_nbr, height, pitch_nbr, rating, rating_level, id_sector) VALUES (21, '2019-11-04 13:59:07.97', '2019-11-04 13:59:07.97', NULL, 1, 'L6', 41, 61, 2, '7a', 12, 15);
INSERT INTO public.way (id, date_of_creation, date_of_update, description, id_account, name, anchor_nbr, height, pitch_nbr, rating, rating_level, id_sector) VALUES (23, '2019-11-04 14:28:49.834', '2019-11-04 14:28:49.834', NULL, 1, 'L1', 51, 67, 2, '5c', 8, 22);
INSERT INTO public.way (id, date_of_creation, date_of_update, description, id_account, name, anchor_nbr, height, pitch_nbr, rating, rating_level, id_sector) VALUES (24, '2019-11-04 14:30:16.346', '2019-11-04 14:30:16.346', NULL, 1, 'L2', 52, 66, 2, '6a', 9, 22);
INSERT INTO public.way (id, date_of_creation, date_of_update, description, id_account, name, anchor_nbr, height, pitch_nbr, rating, rating_level, id_sector) VALUES (25, '2019-11-04 14:30:45.958', '2019-11-04 14:30:45.958', NULL, 1, 'L3', 49, 58, 2, '5b', 7, 22);
INSERT INTO public.way (id, date_of_creation, date_of_update, description, id_account, name, anchor_nbr, height, pitch_nbr, rating, rating_level, id_sector) VALUES (26, '2019-11-04 14:31:16.598', '2019-11-04 14:31:16.598', NULL, 1, 'L4', 51, 62, 2, '5b', 7, 22);
INSERT INTO public.way (id, date_of_creation, date_of_update, description, id_account, name, anchor_nbr, height, pitch_nbr, rating, rating_level, id_sector) VALUES (27, '2019-11-04 14:31:41.008', '2019-11-04 14:31:41.008', NULL, 1, 'L5', 52, 63, 2, '5b', 7, 22);
INSERT INTO public.way (id, date_of_creation, date_of_update, description, id_account, name, anchor_nbr, height, pitch_nbr, rating, rating_level, id_sector) VALUES (28, '2019-11-04 14:32:00.456', '2019-11-04 14:32:00.456', NULL, 1, 'L6', 52, 61, 2, '5b', 7, 22);
INSERT INTO public.way (id, date_of_creation, date_of_update, description, id_account, name, anchor_nbr, height, pitch_nbr, rating, rating_level, id_sector) VALUES (29, '2019-11-04 14:32:17.852', '2019-11-04 14:32:17.852', NULL, 1, 'L7', 53, 64, 2, '5b', 7, 22);
INSERT INTO public.way (id, date_of_creation, date_of_update, description, id_account, name, anchor_nbr, height, pitch_nbr, rating, rating_level, id_sector) VALUES (32, '2019-11-04 22:24:02.497', '2019-11-04 22:24:02.498', NULL, 1, 'L1', 67, 93, 2, '6b', 10, 31);
INSERT INTO public.way (id, date_of_creation, date_of_update, description, id_account, name, anchor_nbr, height, pitch_nbr, rating, rating_level, id_sector) VALUES (33, '2019-11-04 22:25:12.31', '2019-11-04 22:25:12.31', NULL, 1, 'L2', 41, 49, 1, '4c', 5, 31);
INSERT INTO public.way (id, date_of_creation, date_of_update, description, id_account, name, anchor_nbr, height, pitch_nbr, rating, rating_level, id_sector) VALUES (34, '2019-11-04 22:25:38.611', '2019-11-04 22:25:38.611', NULL, 1, 'L3', 58, 73, 2, '6b', 10, 31);
INSERT INTO public.way (id, date_of_creation, date_of_update, description, id_account, name, anchor_nbr, height, pitch_nbr, rating, rating_level, id_sector) VALUES (35, '2019-11-04 22:26:06.406', '2019-11-04 22:26:06.406', NULL, 1, 'L4', 39, 39, 1, '3', 1, 31);
INSERT INTO public.way (id, date_of_creation, date_of_update, description, id_account, name, anchor_nbr, height, pitch_nbr, rating, rating_level, id_sector) VALUES (36, '2019-11-04 22:26:44.642', '2019-11-04 22:26:44.642', NULL, 1, 'L5', 42, 49, 1, '4a', 3, 31);
INSERT INTO public.way (id, date_of_creation, date_of_update, description, id_account, name, anchor_nbr, height, pitch_nbr, rating, rating_level, id_sector) VALUES (38, '2019-11-04 22:33:40.108', '2019-11-04 22:33:40.108', NULL, 1, 'Le nombril de Vénus', 51, 69, 2, '6c', 11, 37);
INSERT INTO public.way (id, date_of_creation, date_of_update, description, id_account, name, anchor_nbr, height, pitch_nbr, rating, rating_level, id_sector) VALUES (39, '2019-11-04 22:34:18.188', '2019-11-04 22:34:18.188', NULL, 1, 'La rose des sables', 61, 83, 2, '7a', 12, 37);
INSERT INTO public.way (id, date_of_creation, date_of_update, description, id_account, name, anchor_nbr, height, pitch_nbr, rating, rating_level, id_sector) VALUES (40, '2019-11-04 22:34:53.31', '2019-11-04 22:34:53.31', NULL, 1, 'Courage, fuyons', 61, 83, 2, '7a', 12, 37);
INSERT INTO public.way (id, date_of_creation, date_of_update, description, id_account, name, anchor_nbr, height, pitch_nbr, rating, rating_level, id_sector) VALUES (41, '2019-11-04 22:35:31.524', '2019-11-04 22:35:31.524', NULL, 1, 'Os Court!', 69, 91, 2, '7b', 13, 37);
INSERT INTO public.way (id, date_of_creation, date_of_update, description, id_account, name, anchor_nbr, height, pitch_nbr, rating, rating_level, id_sector) VALUES (44, '2019-11-04 22:42:33.579', '2019-11-04 22:42:33.58', NULL, 4, 'L1', 19, 25, 1, '5b', 7, 43);
INSERT INTO public.way (id, date_of_creation, date_of_update, description, id_account, name, anchor_nbr, height, pitch_nbr, rating, rating_level, id_sector) VALUES (45, '2019-11-04 22:42:53.322', '2019-11-04 22:42:53.322', NULL, 4, 'L2', 19, 25, 1, '5a', 6, 43);
INSERT INTO public.way (id, date_of_creation, date_of_update, description, id_account, name, anchor_nbr, height, pitch_nbr, rating, rating_level, id_sector) VALUES (46, '2019-11-04 22:43:13.132', '2019-11-04 22:43:13.132', NULL, 4, 'L3', 9, 10, 1, '4c', 5, 43);
INSERT INTO public.way (id, date_of_creation, date_of_update, description, id_account, name, anchor_nbr, height, pitch_nbr, rating, rating_level, id_sector) VALUES (47, '2019-11-04 22:43:27.234', '2019-11-04 22:43:27.234', NULL, 4, 'L4', 19, 25, 1, '4c', 5, 43);
INSERT INTO public.way (id, date_of_creation, date_of_update, description, id_account, name, anchor_nbr, height, pitch_nbr, rating, rating_level, id_sector) VALUES (51, '2019-11-04 22:46:35.826', '2019-11-04 22:46:35.826', NULL, 4, 'Les passagers de la nuit', 19, 25, 1, '5b', 7, 49);
INSERT INTO public.way (id, date_of_creation, date_of_update, description, id_account, name, anchor_nbr, height, pitch_nbr, rating, rating_level, id_sector) VALUES (52, '2019-11-04 22:47:24.049', '2019-11-04 22:47:24.049', NULL, 4, 'Key Largo', 21, 30, 1, '5c', 8, 49);
INSERT INTO public.way (id, date_of_creation, date_of_update, description, id_account, name, anchor_nbr, height, pitch_nbr, rating, rating_level, id_sector) VALUES (53, '2019-11-04 22:48:12.848', '2019-11-04 22:48:12.848', NULL, 4, 'Le facteur sonne deux fois', 23, 30, 1, '6a', 9, 49);
INSERT INTO public.way (id, date_of_creation, date_of_update, description, id_account, name, anchor_nbr, height, pitch_nbr, rating, rating_level, id_sector) VALUES (54, '2019-11-04 22:48:57.725', '2019-11-04 22:48:57.725', NULL, 4, 'Scarface', 23, 30, 1, '6b', 10, 49);
INSERT INTO public.way (id, date_of_creation, date_of_update, description, id_account, name, anchor_nbr, height, pitch_nbr, rating, rating_level, id_sector) VALUES (55, '2019-11-04 22:49:18.938', '2019-11-04 22:49:18.938', NULL, 4, 'Claire', 18, 30, 1, '7a', 12, 50);
INSERT INTO public.way (id, date_of_creation, date_of_update, description, id_account, name, anchor_nbr, height, pitch_nbr, rating, rating_level, id_sector) VALUES (56, '2019-11-04 22:49:53.348', '2019-11-04 22:49:53.348', NULL, 4, 'La nuit du chasseur', 13, 20, 1, '6b', 10, 50);
INSERT INTO public.way (id, date_of_creation, date_of_update, description, id_account, name, anchor_nbr, height, pitch_nbr, rating, rating_level, id_sector) VALUES (57, '2019-11-04 22:50:27.157', '2019-11-04 22:50:27.157', NULL, 4, 'La soif du mal', 23, 30, 1, '6b', 10, 50);
INSERT INTO public.way (id, date_of_creation, date_of_update, description, id_account, name, anchor_nbr, height, pitch_nbr, rating, rating_level, id_sector) VALUES (58, '2019-11-04 22:50:48.357', '2019-11-04 22:50:48.357', NULL, 4, 'Assurance du mal', 21, 30, 1, '7a', 12, 50);
INSERT INTO public.way (id, date_of_creation, date_of_update, description, id_account, name, anchor_nbr, height, pitch_nbr, rating, rating_level, id_sector) VALUES (60, '2019-11-05 09:28:53.234', '2019-11-05 09:28:53.235', NULL, 4, 'Esperenza', 71, 90, 2, '5c', 8, 59);
INSERT INTO public.way (id, date_of_creation, date_of_update, description, id_account, name, anchor_nbr, height, pitch_nbr, rating, rating_level, id_sector) VALUES (61, '2019-11-05 14:53:07.567', '2019-11-05 14:53:07.567', NULL, 4, 'Actions Anticalcaires', 119, 150, 3, '5c', 8, 59);
INSERT INTO public.way (id, date_of_creation, date_of_update, description, id_account, name, anchor_nbr, height, pitch_nbr, rating, rating_level, id_sector) VALUES (62, '2019-11-05 14:54:15.423', '2019-11-05 14:54:15.423', NULL, 4, 'Choukakawa', 119, 150, 3, '6a', 9, 59);
INSERT INTO public.way (id, date_of_creation, date_of_update, description, id_account, name, anchor_nbr, height, pitch_nbr, rating, rating_level, id_sector) VALUES (63, '2019-11-05 14:58:19.83', '2019-11-05 14:58:19.83', NULL, 4, 'Farenheit', 45, 60, 2, '6b', 10, 59);



--
-- TOC entry 2962 (class 0 OID 59354)
-- Dependencies: 197
-- Data for Name: commentary; Type: TABLE DATA; Schema: public; Owner: nanoo
--

INSERT INTO public.commentary (id, date_of_update, date_of_creation, id_account, id_type_of_comment, text, title) VALUES (66, '2019-11-05 15:01:41.708', '2019-11-05 15:01:41.708', 4, 65, 'Tout est dans le titre. quelques voies faciles sur ce petit secteur!', 'Bien pour débuter');
