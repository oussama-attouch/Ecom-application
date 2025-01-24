![Capture d’écran 2025-01-24 125206](https://github.com/user-attachments/assets/c960b950-0349-4df1-9304-64ea8a83a52a)﻿# Ecom-application
📚 Gestion des Produits
-Ce projet illustre une API REST en Java (Spring Boot) combinée avec un front-end Angular pour récupérer et afficher une liste de produits depuis un service.

🖥️ Fonctionnalités principales
Back-end (Spring Boot)

-Récupération de la liste de tous les produits.

![product_list_Controller](https://github.com/user-attachments/assets/061aab92-e79d-441a-a608-445d8ee6b039)

-Récupération des détails d'un produit

Front-end (Angular)
-Consommation de l'API dans Angular

![product_list_ngOnitAng](https://github.com/user-attachments/assets/d0f87fcd-47a7-4d26-937c-ff057e7ecda9)

-ngOnInit() : Méthode appelée au chargement du composant.

-this.http.get(...) : Envoie une requête GET à l'API REST pour récupérer les données des produits.

-Projection fullProduct : Sert à inclure des détails supplémentaires dans les résultats.

-Affichage de la liste des produits.

![product_list](https://github.com/user-attachments/assets/0bb7517b-3dfb-4471-8328-90919dd725ea)

📚 Service de Gestion des Clients
Récupération des informations sur les clients et leurs détails via des projections.

🖥️ Fonctionnalités Principales

-Récupérer la liste de tous les clients.

-Récupérer les détails d'un client spécifique par son ID.

-Utiliser une projection pour obtenir une vue personnalisée des données clients.

![customers_list](https://github.com/user-attachments/assets/610e48bc-bbc0-4d07-b71c-fad04c16fda1)

📦 Gestion des Commandes

Fonctionnalités principales

Back-end :

-Récupération d'une commande complète (avec détails du client et des produits).
![orders](https://github.com/user-attachments/assets/7fce949b-006c-4610-a26b-f9300cedaf84)


Front-end :
![orders_ang](https://github.com/user-attachments/assets/424f1fc7-aad6-4b8b-b912-011507856cdb)

-Récupération et affichage des commandes d'un client spécifique.

-Affichage des détails de la commande :

![Capture d’écran 2025-01-24 124954](https://github.com/user-attachments/assets/5889a891-a1a1-4702-8293-e7c248660121)

-Affichage des détails de la commande

![Capture d’écran 2025-01-24 125206](https://github.com/user-attachments/assets/7ddb4253-cd8c-4cb4-85ea-d49893ccbb01)

-Requête : Envoie une requête GET vers /order-service/fullOrder/{orderId} pour récupérer les détails d'une commande spécifique.




