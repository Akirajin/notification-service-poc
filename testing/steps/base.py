import requests
from behave import given, when, then
from deepdiff import DeepDiff

from requests import Session
import json

client = Session()


@given('I am a user')
def step_impl(context):
    context.client = client


@when('I call GET {url}')
def step_impl(context, url):
    response = context.client.get(f'{url}')
    context.status_code = response.status_code
    context.content = response.content


@when('I call POST {url}')
def step_impl(context, url):
    response = context.client.post(f'{url}', json=json.loads(context.text))
    context.status_code = response.status_code
    context.content = response.content


@then('the response status code should be {httpstatus:d}')
def step_impl(context, httpstatus):
    assert context.status_code == httpstatus


@then('the response body should be a JSON array with the following elements')
def step_impl(context):
    expected_categories = json.loads(context.text)
    actual_categories = json.loads(context.content)
    assert compare_dictionaries(expected_categories, actual_categories,
                                'datetime'), f'Expect: {expected_categories} but was Actual: {actual_categories}'


@step("the log is cleared")
def step_impl(context):
    requests.delete('http://localhost:8080/logs')


def compare_dictionaries(json1, json2, ignore):

    for i in json1:
        i[ignore] = None

    for i in json2:
        i[ignore] = None

    return len(DeepDiff(json1, json2, ignore_order=True)) == 0
