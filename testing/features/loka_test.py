input_data = [
    {
        "country": "US",
        "city": "Boston",
        "currency": "USD",
        "amount": 100
    },
    {
        "country": "FR",
        "city": "Paris",
        "currency": "EUR",
        "amount": 20
    },
    {
        "country": "FR",
        "city": "Lyon",
        "currency": "EUR",
        "amount": 11.4
    },
    {
        "country": "ES",
        "city": "Madrid",
        "currency": "EUR",
        "amount": 8.9
    },
    {
        "country": "UK",
        "city": "London",
        "currency": "GBP",
        "amount": 12.2
    },
    {
        "country": "UK",
        "city": "London",
        "currency": "FBP",
        "amount": 10.9
    }
]


#["currency", "country", "city"]

def aggregate(input_data, param):

    response = dict()

    for p in param:
        for item in input_data:
            if response.get(item[p]) is None:
                del item[p]
                response[input_data[p]] = item
            else:
                del item[p]
                response[input_data[p]] = item



print(aggregate(input_data, ["currency", "country", "city"]))

