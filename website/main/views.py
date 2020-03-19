from django.shortcuts import get_object_or_404, render, redirect
from django.http import HttpResponse, HttpResponseRedirect
from django.http import Http404
from django.urls import reverse
from django.views import generic
from django.contrib import messages
from django.core.paginator import Paginator
import math
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
    queryset = Bug.objects.filter(pk__in=bugs)
    queryset = list(reversed(queryset))
    pagin = Paginator(queryset, 5)
    form = BugForm()
    x = 0
    for bug in bugs:
        x = x + 1
    page_number = request.GET.get('page')
    page_obj = pagin.get_page(page_number)

    if request.method == 'POST':
        form = BugForm(request.POST)
        if form.is_valid():
            form.save()
        return redirect('/main/bugtracker/')

    context = {'bugs': bugs, 'queryset': queryset,
               'form': form, 'x': x, 'page_obj': page_obj}
    return render(request, 'main/bugtracker.html', context)


def updateBug(request, pk):
    bug = Bug.objects.get(id=pk)
    form = BugForm(instance=bug)
    context = {'bug': bug, 'form': form}
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
