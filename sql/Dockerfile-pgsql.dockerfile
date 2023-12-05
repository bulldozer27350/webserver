# Utilisez une image de base PostgreSQL
FROM postgres:latest

# Définissez l'utilisateur et le mot de passe par défaut
ENV POSTGRES_USER postgres
ENV POSTGRES_PASSWORD password

# Copiez les fichiers SQL d'initialisation dans le conteneur
COPY ./init.sql /docker-entrypoint-initdb.d/

# Exposez le port par défaut
EXPOSE 5432