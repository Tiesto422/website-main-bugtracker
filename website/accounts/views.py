from django.shortcuts import get_object_or_404, render, redirect
from django.http import HttpResponse, HttpResponseRedirect
from django.http import Http404
from django.urls import reverse
from django.views import generic
from django.contrib.auth.models import User, auth
from django.contrib import messages
from .models import *
from .forms import *
# Create your views here.


class IndexView(generic.ListView):
    template_name = 'main/index.html'
    context_object_name = 'latest_question_list'

    def get_queryset(self):
        return Question.objects.order_by('-pub_date')[:5]


class DetailView(generic.DetailView):
    model = Question
    template_name = 'main/detail.html'


class ResultsView(generic.DetailView):
    model = Question
    template_name = 'main/results.html'


def vote(request, question_id):
    question = get_object_or_404(Question, pk=question_id)
    try:
        selected_choice = question.choice_set.get(pk=request.POST['choice'])
    except (KeyError, Choice.DoesNotExist):
        return render(request, 'main/detail.html', {'question': question, 'error_message': "You didn't select a choice.",
                                                    })
    else:
        selected_choice.votes += 1
        selected_choice.save()

    return HttpResponseRedirect(reverse('main:results', args=(question_id,)))


def bugtracker(request):
    bugs = Bug.objects.all()
    form = BugForm()
    if request.method == 'POST':
        form = BugForm(request.POST)
        if form.is_valid():
            form.save()
        return redirect('/main/bugtracker/')
    context = {'bugs': bugs, 'form': form}
    return render(request, 'main/bugtracker.html', context)


def updateBug(request, pk):
    bug = Bug.objects.get(id=pk)
    form = BugForm(instance=bug)
    context = {'form': form}
    if request.method == 'POST':
        form = BugForm(request.POST, instance=bug)
        if form.is_valid():
            form.save()
        return redirect('/main/bugtracker/')

    return render(request, 'main/update_bug.html', context)


def deleteBug(request, pk):
    item = Bug.objects.get(id=pk)

    if request.method == 'POST':
        item.delete()
        return redirect('/main/bugtracker/')

    context = {'item': item}
    return render(request, 'main/delete.html', context)


def register(request):

    if request.method == 'POST':
        first_name = request.POST['first_name']
        last_name = request.POST['last_name']
        username = request.POST['username']
        password1 = request.POST['password1']
        password2 = request.POST['password2']
        email = request.POST['email']

        if username == None or password1 == None or email == None:
            messages.info(request, 'invalid entry')
            return redirect('/accounts/register/')

        if password1 == password2:
            if User.objects.filter(username=username).exists():
                messages.info(request, 'username taken')
                return redirect('/accounts/register/')
            elif User.objects.filter(email=email).exists():
                messages.info(request, 'email taken')
                return redirect('/accounts/register/')
            else:
                user = User.objects.create_user(
                    username=username, password=password1, email=email, first_name=first_name, last_name=last_name)
                user.save()
                print('user created')
                return redirect('/accounts/login/')
        else:
            messages.info(request, 'password not matching')
            return redirect('/accounts/register/')
        return redirect('/main/')

    else:
        return render(request, 'main/register.html')


def login(request):
    if request.method == 'POST':
        username = request.POST['username']
        password = request.POST['password']
        user = auth.authenticate(username=username, password=password)

        if user is not None:
            auth.login(request, user)
            return redirect('/main/')
        else:
            messages.info(request, 'invalid credentials')
            return redirect('/accounts/login/')
    else:
        return render(request, 'main/login.html')


def logout(request):
    auth.logout(request)
    return redirect('/main/')
