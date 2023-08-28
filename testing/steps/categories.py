from behave import given, when, then

from requests import Session
import json

client = Session()


@given('I am a user')
def step_impl(context):
    context.client = client


@when('I call GET http://localhost:8080/categories')
def step_impl(context):
    response = context.client.get('http://localhost:8080/categories')
    context.status_code = response.status_code
    context.content = response.content


@then('the response status code should be 200')
def step_impl(context):
    assert context.status_code == 200


@then('the response body should be a JSON array with the following elements')
def step_impl(context):
    expected_categories = json.loads(context.text)
    actual_categories = json.loads(context.content)
    assert actual_categories == expected_categories
