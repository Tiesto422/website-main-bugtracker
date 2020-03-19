import datetime
from django.db import models
from django.utils import timezone

# Create your models here.


class Bug(models.Model):
    title = models.CharField(max_length=200, default='', blank=False)
    fname = models.CharField(max_length=200, default='', blank=True)
    lname = models.CharField(max_length=200, default='', blank=True)
    component = models.CharField(max_length=200, default='', blank=False)
    complete = models.BooleanField(default=False)
    created = models.DateTimeField(auto_now_add=True)
    summary = models.TextField(blank=False, null=True)
    version = models.DecimalField(
        max_digits=4, decimal_places=2, blank=True, null=True)

    def __str__(self):
        return self.title


class Question(models.Model):
    question_text = models.CharField(max_length=200)
    pub_date = models.DateTimeField('date published')

    def was_published_recently(self):
        now = timezone.now()
        return now - datetime.timedelta(days=1) <= self.pub_date <= now

    def __str__(self):
        return self.question_text


class Choice(models.Model):
    question = models.ForeignKey(Question, on_delete=models.CASCADE)
    choice_text = models.CharField(max_length=200)
    votes = models.IntegerField(default=0)

    def __str__(self):
        return self.choice_text
