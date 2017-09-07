This project is built using maven.

How to build
=============
If project root folder is located at C:\BillingEngine then use following command to create a jar file

C:\BillingEngine>mvn clean package

It will create BillingEngine-0.0.1-SNAPSHOT.jar in target directory

How to run
===========
C:\BillingEngine>java -jar target\BillingEngine-0.0.1-SNAPSHOT.jar

Step 1
========
Get a list of all products available in system

Request
--------
GET http://localhost:8080/products

Response
--------
[
    {
        "id": "101",
        "listPrice": 400,
        "salesTaxType": "C",
        "displayName": "Oxford Advance Learners Dictionary with DVD - ROM",
        "currency": "INR"
    },
    {
        "id": "102",
        "listPrice": 150,
        "salesTaxType": "A",
        "displayName": "Philips SHE1350 In-Ear Headphones (Black)",
        "currency": "INR"
    },
    {
        "id": "103",
        "listPrice": 1400,
        "salesTaxType": "A",
        "displayName": "Portronics Muffs XT Wireless Bluetooth Headphone ( Black)",
        "currency": "INR"
    },
    {
        "id": "104",
        "listPrice": 250,
        "salesTaxType": "B",
        "displayName": "Pillsbury Milk Choco Spread, 350g",
        "currency": "INR"
    },
    {
        "id": "105",
        "listPrice": 100,
        "salesTaxType": "B",
        "displayName": "Tetley Green Tea, Lemon & Honey, 30 Tea Bags",
        "currency": "INR"
    }
]

Step 2
=========
To check price of a list of products use one or more of the products obtained in above step along with quantities for each

Request
==========
POST http://localhost:8080/billing/checkprice

[
    {
        "productId": "101",
        "quantity": 1
    },
    {
        "productId": "102",
        "quantity": 1
    },
    {
        "productId": "103",
        "quantity": 1
    },
    {
        "productId": "104",
        "quantity": 1
    },
    {
        "productId": "105",
        "quantity": 1
    }
]

Response
========
{
    "lineItems": [
        {
            "productId": "101",
            "quantity": 1,
            "lineTotal": 400,
            "salesTax": 0,
            "product": {
                "id": "101",
                "listPrice": 400,
                "salesTaxType": "C",
                "displayName": "Oxford Advance Learners Dictionary with DVD - ROM",
                "currency": "INR"
            }
        },
        {
            "productId": "102",
            "quantity": 1,
            "lineTotal": 150,
            "salesTax": 15,
            "product": {
                "id": "102",
                "listPrice": 150,
                "salesTaxType": "A",
                "displayName": "Philips SHE1350 In-Ear Headphones (Black)",
                "currency": "INR"
            }
        },
        {
            "productId": "103",
            "quantity": 1,
            "lineTotal": 1400,
            "salesTax": 140,
            "product": {
                "id": "103",
                "listPrice": 1400,
                "salesTaxType": "A",
                "displayName": "Portronics Muffs XT Wireless Bluetooth Headphone ( Black)",
                "currency": "INR"
            }
        },
        {
            "productId": "104",
            "quantity": 1,
            "lineTotal": 250,
            "salesTax": 50,
            "product": {
                "id": "104",
                "listPrice": 250,
                "salesTaxType": "B",
                "displayName": "Pillsbury Milk Choco Spread, 350g",
                "currency": "INR"
            }
        },
        {
            "productId": "105",
            "quantity": 1,
            "lineTotal": 100,
            "salesTax": 20,
            "product": {
                "id": "105",
                "listPrice": 100,
                "salesTaxType": "B",
                "displayName": "Tetley Green Tea, Lemon & Honey, 30 Tea Bags",
                "currency": "INR"
            }
        }
    ],
    "orderTotal": 2525,
    "lineTotal": 2300,
    "salesTaxTotal": 225
}

If request contains an invalid object then it throws following error response
{
    "timestamp": 1504783760983,
    "status": 500,
    "error": "Internal Server Error",
    "exception": "java.lang.Exception",
    "message": "Found invalid product id : 000",
    "path": "/billing/checkprice"
}