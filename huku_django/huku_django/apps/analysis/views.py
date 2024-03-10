from django.shortcuts import render
from django.http import JsonResponse

# Create your views here.

def find(request, username, password):
    result = 'your username: ' + str(username) + '; password: ' + str(password)
    data = {'python_name': str(username), "python_password": str(password), "token": "abcd1234"}
    return JsonResponse(data)