import { test, expect } from '@playwright/test';

test('test', async ({ page }) => {
  await page.goto('http://localhost:3000/consoles');
  await expect(page.getByText('ConsolesAdd ConsoleConsole')).toBeVisible();
});