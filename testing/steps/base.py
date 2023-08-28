from behave import given, when, then

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
    assert compare_dictionaries(expected_categories, actual_categories, 'datetime')


def compare_dictionaries(list1, list2, excluded_field):
    """
    Compares two lists of dictionaries and returns True if they are equal, False otherwise.

    Args:
      list1: The first list of dictionaries.
      list2: The second list of dictionaries.
      excluded_field: The name of the field to exclude from the comparison.

    Returns:
      True if the dictionaries are equal, False otherwise.
    """

    for dict1 in list1:
        for dict2 in list2:
            if dict1 == dict2:
                continue

            for key, value in dict1.items():
                if key == excluded_field:
                    continue

                if key not in dict2 or value != dict2[key]:
                    return False

                if isinstance(value, list) and isinstance(dict2[key], list):
                    if len(value) != len(dict2[key]):
                        return False

                    for v1, v2 in zip(value, dict2[key]):
                        if v1 != v2:
                            return False

    return True
