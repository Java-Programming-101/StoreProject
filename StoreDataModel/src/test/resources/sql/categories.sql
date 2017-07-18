LOCK TABLES `category` WRITE;
/*!40000 ALTER TABLE `category` DISABLE KEYS */;
INSERT INTO `category` VALUES (1,'Products that need to be highlighted.','NEW ARRIVALS'),
                              (2,'Clothes for social events.','TUXEDO'),
                              (3,'Clothers for winter.','SWEATER'),
                              (4,'Feet acessories.','SHOES'),
                              (5,'Eyes glass.','GLASSES'),
                              (6,'T-shirts.','T-SHIRT'),
                              (7,'Watches.','WATCHES');
/*!40000 ALTER TABLE `category` ENABLE KEYS */;
UNLOCK TABLES;