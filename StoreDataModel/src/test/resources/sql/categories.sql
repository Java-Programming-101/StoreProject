--
-- Dumping data for table `category`
--

LOCK TABLES `category` WRITE;
/*!40000 ALTER TABLE `category` DISABLE KEYS */;
INSERT INTO `category` VALUES (1,'Products that need to be highlighted.','NEW ARRIVALS'),(2,'Clothes for social events.','TUXEDO'),(3,'Clothers for winter.','SWEATER'),(4,'Feet acessories.','SHOES'),(5,'Eyes glass.','GLASSES'),(6,'T-shirts.','T-SHIRT'),(7,'Watches.','WATCHES'),(8,'Assessories.','ACCESSORIES'),(9,'Clothes for men.','MEN'),(10,'Clothes for women.','WOMEN'),(11,'Clothes for kids.','KIDS'),(12,'Adida\'s brand.','ADIDAS'),(13,'Nike\'s brand.','NIKE'),(14,'Tommy brand.','TOMMY'),(15,'Ferrari brand.','FERRARI'),(16,'Ray-ban brand.','RAY-BAN'),(17,'Lacoste brand.','LACOSTE'),(18,'Hugo Boss brand.','HUGO BOSS'),(19,'Dolce & Gabbana brand.','DOLCE & GABBANA '),(20,'Oakley brand.','OAKLEY'),(21,'Citizen brand.','CITIZEN'),(22,'Cassio brand.','CASSIO'),(23,'Orient brand','ORIENT'),(24,'Swatch brand','SWATCH'),(25,'Seiko brand','SEIKO'),(26,'Timex brand','TIMEX'),(27,'Bulova brand','BULOVA');
/*!40000 ALTER TABLE `category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `category_parent`
--

LOCK TABLES `category_parent` WRITE;
/*!40000 ALTER TABLE `category_parent` DISABLE KEYS */;
INSERT INTO `category_parent` VALUES (9,1),(9,7),(10,7),(11,7),(12,7),(13,7),(15,7),(14,6),(8,2),(9,4),(10,4),(11,4),(16,5),(14,3),(17,3),(19,2),(18,2),(20,5),(9,4),(11,5),(21,7),(22,7),(23,7),(24,7),(25,7),(26,7),(27,7);
/*!40000 ALTER TABLE `category_parent` ENABLE KEYS */;
UNLOCK TABLES;
