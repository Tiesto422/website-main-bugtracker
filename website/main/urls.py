from django.urls import path
from django.conf import settings
from django.conf.urls.static import static
from django.contrib import admin
from . import views

app_name = 'main'
urlpatterns = [
    path('', views.IndexView.as_view(), name='index'),
    path('<int:pk>/', views.DetailView.as_view(), name='detail'),
    path('<int:pk>/results/', views.ResultsView.as_view(), name='results'),
    path('<int:question_id>/vote/', views.vote, name='vote'),
    path('bugtracker/', views.bugtracker, name='bugtracker'),
    path('update_bug/<str:pk>/', views.updateBug, name='update_bug'),
    path('delete/<str:pk>/', views.deleteBug, name='delete'),
]

# if settings.DEBUG:
# urlpatterns += static(settings.STATIC_URL,
# document_root=settings.STATIC_ROOT)
