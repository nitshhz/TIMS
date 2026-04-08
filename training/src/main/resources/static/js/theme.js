(function() {
    // Check initial
    const storedTheme = localStorage.getItem('theme');
    if (storedTheme === 'dark' || (!storedTheme && window.matchMedia('(prefers-color-scheme: dark)').matches)) {
        document.documentElement.setAttribute('data-theme', 'dark');
    }

    // After DOM loads, mount the widget
    window.addEventListener('DOMContentLoaded', () => {
        const toggleBtn = document.createElement('button');
        toggleBtn.id = 'theme-toggle-widget';
        toggleBtn.innerHTML = document.documentElement.getAttribute('data-theme') === 'dark' ? '☀️' : '🌙';
        
        // Inline styles for the floating widget
        Object.assign(toggleBtn.style, {
            position: 'fixed',
            bottom: '30px',
            right: '30px',
            width: '50px',
            height: '50px',
            borderRadius: '50%',
            background: 'var(--surface)',
            border: '1px solid var(--border)',
            boxShadow: 'var(--shadow-hover)',
            fontSize: '24px',
            cursor: 'pointer',
            display: 'flex',
            alignItems: 'center',
            justifyContent: 'center',
            zIndex: '9999',
            transition: 'all 0.3s ease',
            padding: '0'
        });

        // Hover fx
        toggleBtn.onmouseover = () => toggleBtn.style.transform = 'scale(1.1)';
        toggleBtn.onmouseout = () => toggleBtn.style.transform = 'scale(1)';

        document.body.appendChild(toggleBtn);

        // Toggle action
        toggleBtn.addEventListener('click', () => {
            const currentTheme = document.documentElement.getAttribute('data-theme');
            const targetTheme = currentTheme === 'dark' ? 'light' : 'dark';
            document.documentElement.setAttribute('data-theme', targetTheme);
            localStorage.setItem('theme', targetTheme);
            toggleBtn.innerHTML = targetTheme === 'dark' ? '☀️' : '🌙';
        });
    });
})();
