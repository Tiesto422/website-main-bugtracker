from django.views.generic import ListView
from django import forms
from django.forms import ModelForm
from django.db import models
from .models import *


class ContactList(ListView):
    paginate_by = 5
    model = Bug


class BugForm(forms.ModelForm):
    title = forms.CharField(required=True, widget=forms.TextInput(
        attrs={'placeholder': 'Title of new bug...(Required)'}))
    fname = forms.CharField(required=False, widget=forms.TextInput(
        attrs={'placeholder': 'Owner firstname...'}))
    lname = forms.CharField(required=False, widget=forms.TextInput(
        attrs={'placeholder': 'Owner lastname...'}))
    component = forms.CharField(required=True, widget=forms.TextInput(
        attrs={'placeholder': 'Component...(Required)'}))
    CHOICES = [(True, 'True'), (False, 'False')]
    complete = forms.BooleanField(
        required=False, widget=forms.Select(choices=CHOICES))
    version = forms.DecimalField(required=False, widget=forms.TextInput(
        attrs={'placeholder': 'Version #...'}))
    summary = forms.CharField(required=True, widget=forms.Textarea(
        attrs={'placeholder': 'Description of bug...(Required)'}))

    class Meta:
        model = Bug
        fields = '__all__'
