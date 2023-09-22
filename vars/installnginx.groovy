#!/usr/bin/env groovy
def call() {
    pipeline {
        agent { label 'agent1' }
        stages {
            stage('install_nginx') { 
                steps {
                    echo 'btngan'
                    sh 'sudo apt-get install nginx -y'
                }
            }
            stage('enable_firewall') { 
                steps {
                    sh "sudo ufw allow 'Nginx HTTP' -y"
                    sh 'sudo rm /etc/nginx/sites-available/default /etc/nginx/sites-enabled/default /var/www/html/index.nginx-debian.html'
                }
            }
            stage('Test') { 
                steps {
                    echo 'btngan2'
                    sh 'sudo systemctl status nginx'
                }
            }
        }
    }
}

