from scipy.stats import gamma
import numpy as np
import matplotlib.pyplot as plt


def posterior_distribution(alpha, beta, samples):
    
    a = alpha + sum(samples)
    b = len(samples) + beta
    
    x = np.linspace(gamma.ppf(0.01, a = a, scale = 1 /b),
                    gamma.ppf(0.99, a = a, scale = 1 /b), 100)
    
    fig, ax = plt.subplots(1, 1)
    ax.plot(x, gamma.pdf(x, a = a, scale = 1 /b),
           'b-', lw=5, alpha=0.6, label='gamma pdf')
    plt.title("Posterior Distribution for alpha={}, beta={}".format(alpha, beta))
    plt.vlines(gamma.interval(alpha=0.94, a=a, scale=1/b), 0, 
               max(gamma.pdf(x, a = a, scale = 1 /b)),
               'r', lw=5, alpha=0.6, label='94% Confidence Interval')
    ax.legend()