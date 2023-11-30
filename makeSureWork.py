import requests




# URL you want to send the GET request to
url = "http://localhost:8080/api/makepayment"  # Replace with your URL

# Headers to be included in the GET request
headers = {
    'User-Agent': 'Your User Agent',  # Replace with your User-Agent header
    'Authorization': 'Bearer YourAccessToken',  # Replace with your Authorization header if needed
    'username': "test",
    'password': 'test2'
    # Add more headers as needed
}

# Sending the GET request with headers
response = requests.get(url, headers=headers)

# Check the response status code
if response.status_code == 200:
    # Request was successful, print the response content
    print(response.json())  # Or response.text for non-JSON content
else:
    # Request failed, print the status code and reason
    print(f"Request failed with status code: {response.status_code} - {response.reason}")
